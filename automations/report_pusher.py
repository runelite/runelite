"""
report_pusher.py — CyberWorld / FLLC Automation Utility
Shared helper: push a markdown report file to Personfu/REPORTS via GitHub API.

Usage (from other scripts):
    from report_pusher import push_report
    push_report("reports/build-status.md", "# Build Status\n...", "Update build status")

Env vars required:
    GITHUB_TOKEN  — PAT with write access to Personfu/REPORTS
"""

import os
import sys
import base64
import json
import urllib.request
import urllib.error
from datetime import datetime, timezone

REPORTS_REPO = "Personfu/REPORTS"
REPORTS_BRANCH = "main"
API_BASE = "https://api.github.com"


def _headers(token: str) -> dict:
    return {
        "Authorization": f"token {token}",
        "Accept": "application/vnd.github.v3+json",
        "Content-Type": "application/json",
        "User-Agent": "CyberWorld-Automation/1.0",
    }


def _api(method: str, path: str, token: str, data: dict | None = None) -> dict:
    url = f"{API_BASE}{path}"
    body = json.dumps(data).encode() if data else None
    req = urllib.request.Request(url, data=body, headers=_headers(token), method=method)
    try:
        with urllib.request.urlopen(req) as resp:
            return json.loads(resp.read())
    except urllib.error.HTTPError as e:
        raise RuntimeError(f"GitHub API {method} {path} → {e.code}: {e.read().decode()}") from e


def _get_sha(path: str, token: str) -> str | None:
    """Return the current blob SHA of a file, or None if it doesn't exist."""
    try:
        result = _api("GET", f"/repos/{REPORTS_REPO}/contents/{path}?ref={REPORTS_BRANCH}", token)
        return result.get("sha")
    except RuntimeError:
        return None


def push_report(path: str, content: str, commit_message: str) -> None:
    """
    Create or update `path` in Personfu/REPORTS with `content` (markdown string).
    Automatically prepends a CyberWorld header and UTC timestamp.
    """
    token = os.environ.get("GITHUB_TOKEN") or os.environ.get("REPORTS_TOKEN")
    if not token:
        print("⚠️  No GITHUB_TOKEN / REPORTS_TOKEN set — skipping REPORTS push", file=sys.stderr)
        return

    timestamp = datetime.now(timezone.utc).strftime("%Y-%m-%d %H:%M:%S UTC")
    full_content = f"<!-- CyberWorld Automation | Generated: {timestamp} -->\n{content}"
    encoded = base64.b64encode(full_content.encode()).decode()

    sha = _get_sha(path, token)
    payload: dict = {
        "message": f"[CyberWorld Bot] {commit_message}",
        "content": encoded,
        "branch": REPORTS_BRANCH,
    }
    if sha:
        payload["sha"] = sha

    _api("PUT", f"/repos/{REPORTS_REPO}/contents/{path}", token, payload)
    print(f"✅  Report pushed → https://github.com/{REPORTS_REPO}/blob/{REPORTS_BRANCH}/{path}")


def dispatch_workflow(owner: str, repo: str, workflow_id: str, inputs: dict | None = None) -> None:
    """Trigger a workflow_dispatch event on another repo."""
    token = os.environ.get("GITHUB_TOKEN") or os.environ.get("REPORTS_TOKEN")
    if not token:
        return
    payload = {"ref": "main"}
    if inputs:
        payload["inputs"] = inputs
    _api("POST", f"/repos/{owner}/{repo}/actions/workflows/{workflow_id}/dispatches", token, payload)
    print(f"🚀  Dispatched {owner}/{repo} → {workflow_id}")


if __name__ == "__main__":
    # Quick self-test
    push_report(
        "meta/automation-test.md",
        "# Automation Self-Test\n\nIf you can read this, `report_pusher.py` is working correctly. ✅",
        "Self-test push from report_pusher"
    )
