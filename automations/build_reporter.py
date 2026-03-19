"""
build_reporter.py — CyberWorld / FLLC Build Reporter
Collects latest CI/build status for all Personfu repositories and pushes
a consolidated markdown report to Personfu/REPORTS.

Env vars:
    GITHUB_TOKEN   — PAT with read access to Personfu repos + write to REPORTS
    DISCORD_WEBHOOK — (optional) webhook URL for Discord notification
"""

import os
import sys
import json
import urllib.request
import urllib.error
from datetime import datetime, timezone
from report_pusher import push_report

API_BASE = "https://api.github.com"
OWNER = "Personfu"

REPOS = [
    "CYBERWORLDSOURCECODELITE",
    "CYBERWORLDSOURCECODE",
    "REPORTS",
]

STATUS_EMOJI = {
    "success": "✅",
    "failure": "❌",
    "cancelled": "⛔",
    "in_progress": "🔄",
    "queued": "⏳",
    "skipped": "⏭️",
    "action_required": "⚠️",
    "neutral": "⚪",
    "stale": "🕰️",
    "timed_out": "⏱️",
}


def _headers(token: str) -> dict:
    return {
        "Authorization": f"token {token}",
        "Accept": "application/vnd.github.v3+json",
        "User-Agent": "CyberWorld-Automation/1.0",
    }


def _get(path: str, token: str) -> dict | list:
    url = f"{API_BASE}{path}"
    req = urllib.request.Request(url, headers=_headers(token))
    try:
        with urllib.request.urlopen(req) as resp:
            return json.loads(resp.read())
    except urllib.error.HTTPError as e:
        if e.code == 404:
            return {}
        raise


def get_latest_run(repo: str, token: str) -> dict:
    """Get the most recent workflow run for a repo."""
    data = _get(f"/repos/{OWNER}/{repo}/actions/runs?per_page=5", token)
    runs = data.get("workflow_runs", []) if isinstance(data, dict) else []
    if not runs:
        return {}
    return runs[0]


def get_repo_info(repo: str, token: str) -> dict:
    """Get basic repo metadata."""
    data = _get(f"/repos/{OWNER}/{repo}", token)
    return data if isinstance(data, dict) else {}


def get_open_issues(repo: str, token: str) -> int:
    data = _get(f"/repos/{OWNER}/{repo}/issues?state=open&per_page=1", token)
    if isinstance(data, list):
        # Use X-Total-Count header workaround — just return len for now
        return len(data)
    return 0


def notify_discord(webhook_url: str, message: str) -> None:
    payload = json.dumps({"content": message, "username": "CyberWorld Bot"}).encode()
    req = urllib.request.Request(
        webhook_url,
        data=payload,
        headers={"Content-Type": "application/json", "User-Agent": "CyberWorld-Automation/1.0"},
        method="POST",
    )
    try:
        with urllib.request.urlopen(req) as resp:
            print(f"📣  Discord notified (HTTP {resp.status})")
    except Exception as e:
        print(f"⚠️  Discord notify failed: {e}", file=sys.stderr)


def build_report(token: str) -> str:
    now = datetime.now(timezone.utc).strftime("%Y-%m-%d %H:%M:%S UTC")
    lines = [
        "# ⚡ CyberWorld Build Status Report",
        f"> Generated: `{now}`  |  Owner: `{OWNER}`",
        "",
        "---",
        "",
        "## 🏗️ Repository Build Status",
        "",
        "| Repository | Branch | Status | Conclusion | Last Run | Stars | Open Issues |",
        "|---|---|---|---|---|---|---|",
    ]

    failed_repos = []
    for repo in REPOS:
        info = get_repo_info(repo, token)
        run = get_latest_run(repo, token)

        name = info.get("name", repo)
        default_branch = info.get("default_branch", "main")
        stars = info.get("stargazers_count", 0)
        open_issues = info.get("open_issues_count", 0)
        repo_url = f"https://github.com/{OWNER}/{repo}"

        if run:
            status = run.get("status", "unknown")
            conclusion = run.get("conclusion") or run.get("status", "unknown")
            emoji = STATUS_EMOJI.get(conclusion, "❓")
            run_url = run.get("html_url", repo_url)
            run_time = run.get("updated_at", "")[:10] if run.get("updated_at") else "—"
            status_cell = f"[{emoji} {conclusion}]({run_url})"
        else:
            status = "no_runs"
            conclusion = "no_runs"
            status_cell = "⚪ No runs"
            run_time = "—"
            emoji = "⚪"

        if conclusion in ("failure", "cancelled", "timed_out", "action_required"):
            failed_repos.append(repo)

        lines.append(
            f"| [{name}]({repo_url}) | `{default_branch}` | `{status}` "
            f"| {status_cell} | {run_time} | ⭐ {stars} | 🐛 {open_issues} |"
        )

    lines += [
        "",
        "---",
        "",
        "## 🚦 Summary",
        "",
    ]

    total = len(REPOS)
    failed = len(failed_repos)
    passing = total - failed

    lines += [
        f"- **Total repositories monitored:** {total}",
        f"- **Passing:** ✅ {passing}",
        f"- **Failing / attention needed:** {'❌ ' + str(failed) + ' → ' + ', '.join(f'`{r}`' for r in failed_repos) if failed else '✅ None'}",
        "",
        "---",
        "",
        "## 🔗 Quick Links",
        "",
        f"- [CYBERWORLDSOURCECODELITE](https://github.com/{OWNER}/CYBERWORLDSOURCECODELITE)",
        f"- [CYBERWORLDSOURCECODE](https://github.com/{OWNER}/CYBERWORLDSOURCECODE)",
        f"- [REPORTS](https://github.com/{OWNER}/REPORTS)",
        "- [FLLC Enterprise IT Solutions](https://www.fllc.net)",
        "- [FLLC Cyber Arsenal](https://www.fllc.net/cyber-arsenal)",
        "",
        "---",
        "",
        "*CyberWorld Automation — Powered by FLLC Enterprise IT Solutions* ⚡",
    ]
    return "\n".join(lines)


def main() -> None:
    token = os.environ.get("GITHUB_TOKEN") or os.environ.get("REPORTS_TOKEN")
    if not token:
        print("❌  GITHUB_TOKEN not set", file=sys.stderr)
        sys.exit(1)

    print("🔍  Collecting build status for all Personfu repos...")
    report = build_report(token)

    date_slug = datetime.now(timezone.utc).strftime("%Y-%m-%d")
    push_report(
        f"build-status/build-status-{date_slug}.md",
        report,
        f"Build status report {date_slug}",
    )
    push_report("build-status/latest.md", report, "Update latest build status")

    webhook = os.environ.get("DISCORD_WEBHOOK")
    if webhook:
        summary = (
            "⚡ **CyberWorld Build Report** updated!\n"
            f"📊 Monitoring {len(REPOS)} repos | "
            f"🔗 https://github.com/{OWNER}/REPORTS/blob/main/build-status/latest.md"
        )
        notify_discord(webhook, summary)

    print("✅  Build report complete.")


if __name__ == "__main__":
    main()
