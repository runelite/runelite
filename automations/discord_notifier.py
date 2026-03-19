"""
discord_notifier.py — CyberWorld / FLLC Discord Notifier
Sends richly-formatted Discord webhook messages for build events,
releases, PRs, and security alerts.

Env vars:
    DISCORD_WEBHOOK      — Discord webhook URL
    GITHUB_TOKEN         — PAT (used to fetch context if GITHUB_* vars are missing)
    GITHUB_REPOSITORY    — set automatically in Actions (e.g. Personfu/CYBERWORLDSOURCECODELITE)
    GITHUB_REF           — set automatically in Actions (e.g. refs/heads/main)
    GITHUB_SHA           — set automatically in Actions
    GITHUB_ACTOR         — set automatically in Actions
    GITHUB_EVENT_NAME    — set automatically in Actions
    GITHUB_RUN_ID        — set automatically in Actions
    NOTIFY_TYPE          — one of: build_success, build_failure, release, pr_opened,
                           pr_merged, security_alert, weekly_digest, custom
    NOTIFY_MESSAGE       — custom message body (used with NOTIFY_TYPE=custom)
    NOTIFY_TITLE         — custom title (used with NOTIFY_TYPE=custom)
"""

import os
import sys
import json
import urllib.request
from datetime import datetime, timezone

# CyberWorld brand colors (Discord sidebar color as decimal)
COLOR_SUCCESS = 0x00FF88    # neon green
COLOR_FAILURE = 0xFF1E50    # hot pink/red
COLOR_INFO    = 0x00DCFF    # neon cyan
COLOR_WARNING = 0xFFD700    # gold
COLOR_PURPLE  = 0x9B00FF    # electric purple
COLOR_NEUTRAL = 0x1E2A4A    # midnight blue

CYBERWORLD_ICON = "https://avatars.githubusercontent.com/u/Personfu"
FLLC_FOOTER = "CyberWorld · FLLC Enterprise IT Solutions · fllc.net"


def _send_webhook(webhook_url: str, payload: dict) -> bool:
    data = json.dumps(payload).encode()
    req = urllib.request.Request(
        webhook_url,
        data=data,
        headers={"Content-Type": "application/json", "User-Agent": "CyberWorld-Automation/1.0"},
        method="POST",
    )
    try:
        with urllib.request.urlopen(req) as resp:
            print(f"✅  Discord message sent (HTTP {resp.status})")
            return True
    except urllib.error.HTTPError as e:
        print(f"❌  Discord webhook failed: {e.code} {e.read().decode()}", file=sys.stderr)
        return False


def _embed(title: str, description: str, color: int, fields: list[dict] | None = None,
           url: str | None = None) -> dict:
    embed: dict = {
        "title": title,
        "description": description,
        "color": color,
        "timestamp": datetime.now(timezone.utc).isoformat(),
        "footer": {"text": FLLC_FOOTER},
    }
    if url:
        embed["url"] = url
    if fields:
        embed["fields"] = fields
    return embed


def _run_url() -> str:
    repo = os.environ.get("GITHUB_REPOSITORY", "Personfu/CYBERWORLDSOURCECODELITE")
    run_id = os.environ.get("GITHUB_RUN_ID", "")
    if run_id:
        return f"https://github.com/{repo}/actions/runs/{run_id}"
    return f"https://github.com/{repo}/actions"


def _short_sha() -> str:
    return os.environ.get("GITHUB_SHA", "")[:7] or "unknown"


def _ref_name() -> str:
    ref = os.environ.get("GITHUB_REF", "")
    return ref.replace("refs/heads/", "").replace("refs/tags/", "") or "main"


def build_success_message() -> dict:
    repo = os.environ.get("GITHUB_REPOSITORY", "Personfu/CYBERWORLDSOURCECODELITE")
    actor = os.environ.get("GITHUB_ACTOR", "unknown")
    return {
        "username": "CyberWorld CI",
        "embeds": [_embed(
            title="✅  Build Passed",
            description=(
                f"**Repository:** `{repo}`\n"
                f"**Branch:** `{_ref_name()}`\n"
                f"**Commit:** `{_short_sha()}`\n"
                f"**Triggered by:** `{actor}`"
            ),
            color=COLOR_SUCCESS,
            url=_run_url(),
            fields=[
                {"name": "🔗 View Run", "value": f"[Click here]({_run_url()})", "inline": True},
                {"name": "📊 Reports", "value": "[Personfu/REPORTS](https://github.com/Personfu/REPORTS)", "inline": True},
            ]
        )]
    }


def build_failure_message() -> dict:
    repo = os.environ.get("GITHUB_REPOSITORY", "Personfu/CYBERWORLDSOURCECODELITE")
    actor = os.environ.get("GITHUB_ACTOR", "unknown")
    return {
        "username": "CyberWorld CI",
        "embeds": [_embed(
            title="❌  Build FAILED",
            description=(
                f"**Repository:** `{repo}`\n"
                f"**Branch:** `{_ref_name()}`\n"
                f"**Commit:** `{_short_sha()}`\n"
                f"**Triggered by:** `{actor}`\n\n"
                f"⚠️ Investigate immediately — check the run logs."
            ),
            color=COLOR_FAILURE,
            url=_run_url(),
            fields=[
                {"name": "🔗 View Logs", "value": f"[Click here]({_run_url()})", "inline": True},
                {"name": "🛠️ Fix Guide", "value": "[Troubleshooting](https://github.com/Personfu/CYBERWORLDSOURCECODELITE/wiki/Troubleshooting)", "inline": True},
            ]
        )]
    }


def release_message() -> dict:
    repo = os.environ.get("GITHUB_REPOSITORY", "Personfu/CYBERWORLDSOURCECODELITE")
    ref = _ref_name()
    release_url = f"https://github.com/{repo}/releases/tag/{ref}"
    return {
        "username": "CyberWorld Release Bot",
        "embeds": [_embed(
            title=f"🚀  New Release: {ref}",
            description=(
                f"**CyberWorld** `{ref}` has been released!\n\n"
                f"> *Enter the Grid. Hack the System. Defend the Network.*\n\n"
                f"🌐 Powered by **FLLC Enterprise IT Solutions**"
            ),
            color=COLOR_PURPLE,
            url=release_url,
            fields=[
                {"name": "📦 Download", "value": f"[GitHub Release]({release_url})", "inline": True},
                {"name": "🔗 Repo", "value": f"[{repo}](https://github.com/{repo})", "inline": True},
                {"name": "🌐 FLLC", "value": "[fllc.net](https://www.fllc.net)", "inline": True},
            ]
        )]
    }


def pr_opened_message() -> dict:
    repo = os.environ.get("GITHUB_REPOSITORY", "Personfu/CYBERWORLDSOURCECODELITE")
    actor = os.environ.get("GITHUB_ACTOR", "unknown")
    return {
        "username": "CyberWorld PR Bot",
        "embeds": [_embed(
            title="🔀  New Pull Request Opened",
            description=(
                f"**Repository:** `{repo}`\n"
                f"**Branch:** `{_ref_name()}`\n"
                f"**Author:** `{actor}`\n\n"
                f"A new contribution is ready for review!"
            ),
            color=COLOR_INFO,
            url=f"https://github.com/{repo}/pulls",
        )]
    }


def pr_merged_message() -> dict:
    repo = os.environ.get("GITHUB_REPOSITORY", "Personfu/CYBERWORLDSOURCECODELITE")
    actor = os.environ.get("GITHUB_ACTOR", "unknown")
    return {
        "username": "CyberWorld PR Bot",
        "embeds": [_embed(
            title="✅  Pull Request Merged",
            description=(
                f"**Repository:** `{repo}`\n"
                f"**Branch:** `{_ref_name()}`\n"
                f"**Merged by:** `{actor}`\n\n"
                f"Changes are now live on `main`! 🎉"
            ),
            color=COLOR_SUCCESS,
        )]
    }


def security_alert_message() -> dict:
    repo = os.environ.get("GITHUB_REPOSITORY", "Personfu/CYBERWORLDSOURCECODELITE")
    custom_msg = os.environ.get("NOTIFY_MESSAGE", "A security issue was detected in the codebase.")
    return {
        "username": "CyberWorld Security",
        "embeds": [_embed(
            title="🔐  Security Alert",
            description=(
                f"**Repository:** `{repo}`\n\n"
                f"{custom_msg}\n\n"
                f"⚠️ Please review the [Security Scan Report](https://github.com/Personfu/REPORTS/tree/main/security-audit) immediately."
            ),
            color=COLOR_WARNING,
            fields=[
                {"name": "🛡️ Audit Report", "value": "[View in REPORTS](https://github.com/Personfu/REPORTS/tree/main/security-audit)", "inline": True},
                {"name": "🔗 FLLC Cyber Arsenal", "value": "[fllc.net/cyber-arsenal](https://www.fllc.net/cyber-arsenal)", "inline": True},
            ]
        )]
    }


def weekly_digest_message() -> dict:
    return {
        "username": "CyberWorld Weekly Bot",
        "embeds": [_embed(
            title="📅  CyberWorld Weekly Digest Published",
            description=(
                "Your weekly CyberWorld activity summary is ready!\n\n"
                "🔍 Build status, repo health, plugin inventory, and security audit "
                "have all been updated in **Personfu/REPORTS**.\n\n"
                "> *Enter the Grid. Hack the System. Defend the Network.*"
            ),
            color=COLOR_PURPLE,
            url="https://github.com/Personfu/REPORTS",
            fields=[
                {"name": "📊 Full Reports", "value": "[Personfu/REPORTS](https://github.com/Personfu/REPORTS)", "inline": True},
                {"name": "🌐 FLLC", "value": "[fllc.net](https://www.fllc.net)", "inline": True},
                {"name": "🎮 CyberWorld", "value": "[Play Now](https://personfu.github.io)", "inline": True},
            ]
        )]
    }


def custom_message() -> dict:
    title = os.environ.get("NOTIFY_TITLE", "⚡ CyberWorld Notification")
    body = os.environ.get("NOTIFY_MESSAGE", "No message provided.")
    return {
        "username": "CyberWorld Bot",
        "embeds": [_embed(title=title, description=body, color=COLOR_INFO)]
    }


MESSAGE_BUILDERS = {
    "build_success": build_success_message,
    "build_failure": build_failure_message,
    "release": release_message,
    "pr_opened": pr_opened_message,
    "pr_merged": pr_merged_message,
    "security_alert": security_alert_message,
    "weekly_digest": weekly_digest_message,
    "custom": custom_message,
}


def main() -> None:
    webhook = os.environ.get("DISCORD_WEBHOOK")
    if not webhook:
        print("⚠️  DISCORD_WEBHOOK not set — skipping notification", file=sys.stderr)
        sys.exit(0)

    notify_type = os.environ.get("NOTIFY_TYPE", "custom")
    builder = MESSAGE_BUILDERS.get(notify_type, custom_message)

    print(f"📣  Sending Discord notification: {notify_type}")
    payload = builder()
    success = _send_webhook(webhook, payload)
    if not success:
        sys.exit(1)


if __name__ == "__main__":
    main()
