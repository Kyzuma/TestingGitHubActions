# GitHub Actions CI/CD Setup

## Overview

This repository uses a smart CI/CD setup that solves the common problem of path-filtered workflows and GitHub branch protection rules.

## Problem Solved

When you have separate workflows for frontend and backend with path filtering, GitHub branch protection rules can get stuck waiting for status checks that will never run. For example:
- User changes only frontend code
- Backend workflow doesn't trigger (due to path filtering)
- Branch protection rule waits forever for backend status check
- PR cannot be merged

## Solution

We use a **central orchestrator workflow** (`ci.yml`) that:

1. **Always runs** on every push/PR
2. **Detects changes** using path filtering
3. **Conditionally runs** the appropriate tests
4. **Provides a single status check** for branch protection

## Workflow Structure

```
ci.yml (Central Orchestrator)
├── changes (detects what changed)
├── frontend-tests (runs if frontend changed)
├── backend-tests (runs if backend changed)
└── ci-status (always runs, provides final status)
```

## Branch Protection Setup

In your GitHub repository settings, set up branch protection rules to require:

**Required Status Check:** `CI Status Check / ci-status`

This single status check will:
- ✅ Pass if only frontend changes and frontend tests pass
- ✅ Pass if only backend changes and backend tests pass  
- ✅ Pass if both change and both test suites pass
- ❌ Fail if any applicable tests fail

## Benefits

1. **Always provides status**: No more pending status checks
2. **Efficient**: Only runs tests for changed code
3. **Single check**: Simple branch protection rule setup
4. **Clear feedback**: Shows exactly what was tested
5. **Flexible**: Easy to add more components (mobile, docs, etc.)

## Workflow Files

- `ci.yml` - Central orchestrator (use this for branch protection)
- `frontend.yml` - Frontend-specific tests (called by orchestrator)
- `backend.yml` - Backend-specific tests (called by orchestrator)

## Usage

The workflows will automatically:
- Run on every push to `main`/`develop`
- Run on every PR to `main`
- Detect what code changed
- Run only the necessary tests
- Provide a single status check result

No manual intervention required!