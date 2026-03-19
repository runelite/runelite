"""
repo_health.py — CyberWorld / FLLC Repository Health Monitor
Checks ALL Personfu repositories for:
  - Open issues and PRs
  - Last commit date (staleness check)
  - Stars, forks, watchers
  - License presence
  - README presence
  - Workflow run success rate (last 10 runs)
Pushes a health dashboard to Personfu/REPORTS.

Env vars:
    GITHUB_TOKEN — PAT with read access to Personfu repos + write to REPORTS
    DISCORD_WEBHOOK — (optional) Discord webhook for health alerts
"""

import os
import sys
import json
import urllib.request
import urllib.error
from datetime import datetime, timezone, timedelta
from report_pusher import push_report

API_BASE = "https://api.github.com"
OWNER = "Personfu"

# All known Personfu repos to monitor
REPOS = [
    "CYBERWORLDSOURCECODELITE",
    "CYBERWORLDSOURCECODE",
    "REPORTS",
]

STALE_DAYS = 30  # Flag repos with no commits in this many days


def _headers(token: str) -> dict:
    return {
        "Authorization": f"token {token}",
        "Accept": "application/vnd.github.v3+json",
        "User-Agent": "CyberWorld-Automation/1.0",
    }


def _get(path: str, token: str, default=None):
    url = f"{API_BASE}{path}"
    req = urllib.request.Request(url, headers=_headers(token))
    try:
        with urllib.request.urlopen(req) as resp:
            return json.loads(resp.read())
    except urllib.error.HTTPError as e:
        if e.code in (404, 403):
            return default
        raise


def get_repo_info(repo: str, token: str) -> dict:
    return _get(f"/repos/{OWNER}/{repo}", token, {})


def get_recent_commits(repo: str, token: str) -> list:
    return _get(f"/repos/{OWNER}/{repo}/commits?per_page=1", token, [])


def get_workflow_runs(repo: str, token: str) -> list:
    data = _get(f"/repos/{OWNER}/{repo}/actions/runs?per_page=10", token, {})
    if isinstance(data, dict):
        return data.get("workflow_runs", [])
    return []


def get_open_prs(repo: str, token: str) -> int:
    data = _get(f"/repos/{OWNER}/{repo}/pulls?state=open&per_page=1", token, [])
    return len(data) if isinstance(data, list) else 0


def health_score(info: dict, runs: list, last_commit_days: int) -> tuple[int, str]:
    """Return (score 0-100, grade letter)."""
    score = 100

    # Penalise staleness
    if last_commit_days > 90:
        score -= 30
    elif last_commit_days > 30:
        score -= 15

    # Penalise failing workflows
    if runs:
        recent_conclusions = [r.get("conclusion") for r in runs if r.get("conclusion")]
        failures = sum(1 for c in recent_conclusions if c in ("failure", "timed_out", "cancelled"))
        fail_rate = failures / len(recent_conclusions) if recent_conclusions else 0
        score -= int(fail_rate * 40)

    # Penalise missing license
    if not info.get("license"):
        score -= 5

    # Penalise archived
    if info.get("archived"):
        score -= 20

    score = max(0, min(100, score))
    if score >= 90:
        grade = "A"
    elif score >= 75:
        grade = "B"
    elif score >= 60:
        grade = "C"
    elif score >= 40:
        grade = "D"
    else:
        grade = "F"

    return score, grade


GRADE_EMOJI = {"A": "🟢", "B": "🔵", "C": "🟡", "D": "🟠", "F": "🔴"}


def build_report(token: str) -> str:
    now = datetime.now(timezone.utc)
    now_str = now.strftime("%Y-%m-%d %H:%M:%S UTC")

    repo_data = []
    for repo in REPOS:
        info = get_repo_info(repo, token)
        if not info:
            repo_data.append({"repo": repo, "error": True})
            continue

        commits = get_recent_commits(repo, token)
        runs = get_workflow_runs(repo, token)
        open_prs = get_open_prs(repo, token)

        last_commit_date = None
        last_commit_days = 9999
        if commits and isinstance(commits, list):
            raw_date = commits[0].get("commit", {}).get("author", {}).get("date", "")
            if raw_date:
                last_commit_date = raw_date[:10]
                try:
                    dt = datetime.fromisoformat(raw_date.replace("Z", "+00:00"))
                    last_commit_days = (now - dt).days
                except ValueError:
                    pass

        run_summary = "—"
        if runs:
            total_runs = len(runs)
            success = sum(1 for r in runs if r.get("conclusion") == "success")
            run_summary = f"{success}/{total_runs} passing"

        score, grade = health_score(info, runs, last_commit_days)
        grade_emoji = GRADE_EMOJI.get(grade, "❓")

        staleness = ""
        if last_commit_days > STALE_DAYS:
            staleness = f" ⚠️ ({last_commit_days}d ago)"

        repo_data.append({
            "repo": repo,
            "error": False,
            "name": info.get("name", repo),
            "description": info.get("description") or "—",
            "stars": info.get("stargazers_count", 0),
            "forks": info.get("forks_count", 0),
            "watchers": info.get("watchers_count", 0),
            "open_issues": info.get("open_issues_count", 0),
            "open_prs": open_prs,
            "default_branch": info.get("default_branch", "main"),
            "language": info.get("language") or "—",
            "license": info.get("license", {}).get("spdx_id", "None") if info.get("license") else "None",
            "archived": info.get("archived", False),
            "last_commit": last_commit_date or "—",
            "last_commit_days": last_commit_days,
            "staleness": staleness,
            "run_summary": run_summary,
            "score": score,
            "grade": grade,
            "grade_emoji": grade_emoji,
        })

    lines = [
        "# 🛡️ CyberWorld Repository Health Dashboard",
        f"> Generated: `{now_str}`  |  Monitoring: **{len(REPOS)}** repositories",
        "",
        "---",
        "",
        "## 📋 Health Overview",
        "",
        "| Repository | Grade | Score | Last Commit | Issues | PRs | CI Runs | Stars | Language |",
        "|---|---|---|---|---|---|---|---|---|",
    ]

    for d in repo_data:
        if d.get("error"):
            lines.append(
                f"| [{d['repo']}](https://github.com/{OWNER}/{d['repo']}) "
                f"| ❓ | — | — | — | — | — | — | — |"
            )
            continue

        repo_url = f"https://github.com/{OWNER}/{d['repo']}"
        archived_tag = " `[archived]`" if d["archived"] else ""
        lines.append(
            f"| [{d['name']}]({repo_url}){archived_tag} "
            f"| {d['grade_emoji']} **{d['grade']}** "
            f"| {d['score']}/100 "
            f"| `{d['last_commit']}`{d['staleness']} "
            f"| 🐛 {d['open_issues']} "
            f"| 🔀 {d['open_prs']} "
            f"| {d['run_summary']} "
            f"| ⭐ {d['stars']} "
            f"| {d['language']} |"
        )

    lines += ["", "---", "", "## 📊 Repo Details", ""]

    for d in repo_data:
        if d.get("error"):
            continue
        repo_url = f"https://github.com/{OWNER}/{d['repo']}"
        lines += [
            f"### [{d['name']}]({repo_url})",
            "",
            f"> {d['description']}",
            "",
            f"| Field | Value |",
            f"|---|---|",
            f"| **Health Grade** | {d['grade_emoji']} {d['grade']} ({d['score']}/100) |",
            f"| **Default Branch** | `{d['default_branch']}` |",
            f"| **Language** | {d['language']} |",
            f"| **License** | `{d['license']}` |",
            f"| **Stars** | ⭐ {d['stars']} |",
            f"| **Forks** | 🍴 {d['forks']} |",
            f"| **Open Issues** | 🐛 {d['open_issues']} |",
            f"| **Open PRs** | 🔀 {d['open_prs']} |",
            f"| **Last Commit** | `{d['last_commit']}`{d['staleness']} |",
            f"| **Recent CI** | {d['run_summary']} |",
            f"| **Archived** | {'⚠️ Yes' if d['archived'] else 'No'} |",
            "",
        ]

    lines += [
        "---",
        "",
        "## 🎯 Health Score Legend",
        "",
        "| Grade | Score Range | Meaning |",
        "|---|---|---|",
        "| 🟢 A | 90–100 | Excellent — actively maintained, all CI passing |",
        "| 🔵 B | 75–89  | Good — minor issues or slight staleness |",
        "| 🟡 C | 60–74  | Fair — some CI failures or moderate staleness |",
        "| 🟠 D | 40–59  | Poor — frequent failures or long inactivity |",
        "| 🔴 F | 0–39   | Critical — needs immediate attention |",
        "",
        "---",
        "",
        "*CyberWorld Automation — Powered by FLLC Enterprise IT Solutions* ⚡",
    ]
    return "\n".join(lines)


def notify_discord_health(webhook_url: str, repo_data: list) -> None:
    import urllib.request
    failing = [d for d in repo_data if not d.get("error") and d.get("grade") in ("D", "F")]
    if not failing:
        msg = "✅ **CyberWorld Repo Health**: All repositories healthy!"
    else:
        repo_list = ", ".join(f"`{d['name']}`" for d in failing)
        msg = f"⚠️ **CyberWorld Repo Health Alert**: Repos needing attention: {repo_list}"

    payload = json.dumps({"content": msg, "username": "CyberWorld Health Monitor"}).encode()
    req = urllib.request.Request(
        webhook_url,
        data=payload,
        headers={"Content-Type": "application/json", "User-Agent": "CyberWorld-Automation/1.0"},
        method="POST",
    )
    try:
        with urllib.request.urlopen(req):
            print("📣  Discord health alert sent")
    except Exception as e:
        print(f"⚠️  Discord notify failed: {e}", file=sys.stderr)


def main() -> None:
    token = os.environ.get("GITHUB_TOKEN") or os.environ.get("REPORTS_TOKEN")
    if not token:
        print("❌  GITHUB_TOKEN not set", file=sys.stderr)
        sys.exit(1)

    print("🔍  Checking health of all Personfu repositories...")
    report = build_report(token)

    date_slug = datetime.now(timezone.utc).strftime("%Y-%m-%d")
    push_report(
        f"repo-health/repo-health-{date_slug}.md",
        report,
        f"Repo health report {date_slug}",
    )
    push_report("repo-health/latest.md", report, "Update latest repo health dashboard")

    webhook = os.environ.get("DISCORD_WEBHOOK")
    if webhook:
        # Re-collect summary data for Discord message
        repo_data = []
        for repo in REPOS:
            info = get_repo_info(repo, token)
            if info:
                runs = get_workflow_runs(repo, token)
                _, grade = health_score(info, runs, 9999)
                repo_data.append({"name": repo, "grade": grade, "error": False})
        notify_discord_health(webhook, repo_data)

    print("✅  Repo health check complete.")


if __name__ == "__main__":
    main()
