"""
security_audit.py — CyberWorld / FLLC Security Auditor
Scans the repository for common security issues:
  - Hardcoded secrets / credentials patterns
  - TODO/FIXME/HACK annotations with security implications
  - Dependency version pins (reports unpinned GitHub Actions)
  - Files with overly permissive patterns
  - Sensitive file names accidentally committed
Pushes a full audit report to Personfu/REPORTS.

Env vars:
    GITHUB_TOKEN      — PAT with write access to REPORTS
    GITHUB_WORKSPACE  — set automatically in GitHub Actions
    DISCORD_WEBHOOK   — (optional) Discord alert if HIGH findings found
"""

import os
import sys
import re
from pathlib import Path
from datetime import datetime, timezone
from report_pusher import push_report

SEVERITY_CRITICAL = "🔴 CRITICAL"
SEVERITY_HIGH = "🟠 HIGH"
SEVERITY_MEDIUM = "🟡 MEDIUM"
SEVERITY_LOW = "🔵 LOW"
SEVERITY_INFO = "⚪ INFO"

# (pattern, description, severity, file_globs)
SECRET_PATTERNS = [
    (re.compile(r'(?i)(password|passwd|pwd)\s*=\s*["\'][^"\']{4,}["\']'),
     "Hardcoded password string", SEVERITY_CRITICAL, ["**/*.java", "**/*.py", "**/*.yml", "**/*.yaml", "**/*.properties", "**/*.json"]),
    (re.compile(r'(?i)(api_key|apikey|api-key)\s*[=:]\s*["\']?[A-Za-z0-9_\-]{16,}["\']?'),
     "Hardcoded API key", SEVERITY_CRITICAL, ["**/*.java", "**/*.py", "**/*.yml", "**/*.properties"]),
    (re.compile(r'(?i)(secret|token)\s*=\s*["\'][A-Za-z0-9_\-]{8,}["\']'),
     "Hardcoded secret/token", SEVERITY_HIGH, ["**/*.java", "**/*.py", "**/*.yml"]),
    (re.compile(r'(?i)ghp_[A-Za-z0-9]{36}'),
     "GitHub Personal Access Token (ghp_)", SEVERITY_CRITICAL, ["**/*"]),
    (re.compile(r'(?i)github_pat_[A-Za-z0-9_]{82}'),
     "GitHub Fine-Grained PAT", SEVERITY_CRITICAL, ["**/*"]),
    (re.compile(r'(?i)sk-[A-Za-z0-9]{32,}'),
     "OpenAI / Stripe secret key pattern", SEVERITY_CRITICAL, ["**/*"]),
    (re.compile(r'(?i)AKIA[0-9A-Z]{16}'),
     "AWS Access Key ID", SEVERITY_CRITICAL, ["**/*"]),
    (re.compile(r'(?i)(aws_secret_access_key)\s*[=:]\s*[A-Za-z0-9/+]{40}'),
     "AWS Secret Access Key", SEVERITY_CRITICAL, ["**/*"]),
    (re.compile(r'(?i)discord\.com/api/webhooks/[0-9]+/[A-Za-z0-9_\-]+'),
     "Discord webhook URL exposed", SEVERITY_HIGH, ["**/*"]),
    (re.compile(r'(?i)(jdbc|db)\s*[=:]\s*["\'].*password["\']'),
     "Database connection string with password", SEVERITY_HIGH, ["**/*.java", "**/*.properties", "**/*.yml"]),
    (re.compile(r'-----BEGIN\s+(RSA|EC|OPENSSH|DSA)\s+PRIVATE\s+KEY'),
     "Private key embedded in file", SEVERITY_CRITICAL, ["**/*"]),
]

SECURITY_TODOS = re.compile(
    r'(?i)(TODO|FIXME|HACK|XXX)\s*:?\s*(.*?(securit|auth|cred|secret|token|password|inject|xss|csrf|sql).{0,80})',
    re.MULTILINE,
)

UNPINNED_ACTION = re.compile(r'uses:\s+([A-Za-z0-9_\-]+/[A-Za-z0-9_\-]+)@(main|master|latest|v\d+)\b')

SENSITIVE_FILENAMES = [
    ".env", ".env.local", ".env.production", "id_rsa", "id_ed25519",
    "*.pem", "*.key", "*.pfx", "*.p12", "secrets.yml", "secrets.yaml",
    "credentials.json", "service-account.json",
]

# Directories to skip
SKIP_DIRS = {".git", "node_modules", "build", "dist", ".gradle", "__pycache__"}

# Extensions to scan for secrets
SCAN_EXTENSIONS = {
    ".java", ".py", ".yml", ".yaml", ".json", ".xml", ".properties",
    ".gradle", ".kts", ".sh", ".md", ".txt", ".env",
}


def find_repo_root() -> Path:
    workspace = os.environ.get("GITHUB_WORKSPACE")
    if workspace:
        return Path(workspace)
    current = Path(__file__).resolve()
    for parent in [current.parent.parent, current.parent.parent.parent]:
        if (parent / "runelite-client").exists() or (parent / ".git").exists():
            return parent
    raise RuntimeError("Cannot locate repo root")


def _iter_files(root: Path):
    for p in root.rglob("*"):
        if any(skip in p.parts for skip in SKIP_DIRS):
            continue
        if p.is_file() and p.suffix.lower() in SCAN_EXTENSIONS:
            yield p


def scan_secrets(root: Path) -> list[dict]:
    findings = []
    for filepath in _iter_files(root):
        try:
            text = filepath.read_text(encoding="utf-8", errors="ignore")
        except OSError:
            continue
        for pattern, description, severity, _ in SECRET_PATTERNS:
            for match in pattern.finditer(text):
                line_no = text[:match.start()].count("\n") + 1
                # Redact the matched value in output
                excerpt = match.group(0)[:80].replace("\n", " ")
                redacted = re.sub(r'(["\'][A-Za-z0-9_\-/+]{6})[A-Za-z0-9_\-/+]+(["\']?)',
                                  r'\1****\2', excerpt)
                findings.append({
                    "severity": severity,
                    "file": str(filepath.relative_to(root)),
                    "line": line_no,
                    "description": description,
                    "excerpt": redacted,
                })
    return findings


def scan_security_todos(root: Path) -> list[dict]:
    findings = []
    for filepath in _iter_files(root):
        try:
            text = filepath.read_text(encoding="utf-8", errors="ignore")
        except OSError:
            continue
        for match in SECURITY_TODOS.finditer(text):
            line_no = text[:match.start()].count("\n") + 1
            findings.append({
                "severity": SEVERITY_MEDIUM,
                "file": str(filepath.relative_to(root)),
                "line": line_no,
                "description": f"{match.group(1)}: security-related annotation",
                "excerpt": match.group(0)[:120].replace("\n", " ").strip(),
            })
    return findings


def scan_unpinned_actions(root: Path) -> list[dict]:
    findings = []
    workflows_dir = root / ".github" / "workflows"
    if not workflows_dir.exists():
        return findings
    for wf in workflows_dir.glob("*.yml"):
        try:
            text = wf.read_text(encoding="utf-8", errors="ignore")
        except OSError:
            continue
        for match in UNPINNED_ACTION.finditer(text):
            line_no = text[:match.start()].count("\n") + 1
            findings.append({
                "severity": SEVERITY_LOW,
                "file": str(wf.relative_to(root)),
                "line": line_no,
                "description": f"Unpinned GitHub Action: `{match.group(1)}@{match.group(2)}`",
                "excerpt": f"uses: {match.group(1)}@{match.group(2)}",
            })
    return findings


def scan_sensitive_files(root: Path) -> list[dict]:
    findings = []
    for filepath in root.rglob("*"):
        if any(skip in filepath.parts for skip in SKIP_DIRS):
            continue
        if not filepath.is_file():
            continue
        fname = filepath.name.lower()
        for pattern in SENSITIVE_FILENAMES:
            if pattern.startswith("*"):
                if fname.endswith(pattern[1:]):
                    findings.append({
                        "severity": SEVERITY_HIGH,
                        "file": str(filepath.relative_to(root)),
                        "line": 0,
                        "description": f"Sensitive file pattern `{pattern}` committed to repo",
                        "excerpt": filepath.name,
                    })
                    break
            elif fname == pattern:
                findings.append({
                    "severity": SEVERITY_HIGH,
                    "file": str(filepath.relative_to(root)),
                    "line": 0,
                    "description": f"Sensitive file `{pattern}` committed to repo",
                    "excerpt": filepath.name,
                })
                break
    return findings


SEVERITY_ORDER = {
    SEVERITY_CRITICAL: 0,
    SEVERITY_HIGH: 1,
    SEVERITY_MEDIUM: 2,
    SEVERITY_LOW: 3,
    SEVERITY_INFO: 4,
}


def build_report(all_findings: list[dict], scan_stats: dict) -> str:
    now = datetime.now(timezone.utc).strftime("%Y-%m-%d %H:%M:%S UTC")
    all_findings.sort(key=lambda f: (SEVERITY_ORDER.get(f["severity"], 99), f["file"], f["line"]))

    critical = sum(1 for f in all_findings if f["severity"] == SEVERITY_CRITICAL)
    high = sum(1 for f in all_findings if f["severity"] == SEVERITY_HIGH)
    medium = sum(1 for f in all_findings if f["severity"] == SEVERITY_MEDIUM)
    low = sum(1 for f in all_findings if f["severity"] == SEVERITY_LOW)
    total = len(all_findings)

    if critical > 0:
        overall = "🔴 CRITICAL — Immediate action required"
    elif high > 0:
        overall = "🟠 HIGH — Action recommended"
    elif medium > 0:
        overall = "🟡 MEDIUM — Review suggested"
    elif low > 0:
        overall = "🔵 LOW — Minor issues"
    else:
        overall = "✅ CLEAN — No issues found"

    lines = [
        "# 🔐 CyberWorld Security Audit Report",
        f"> Generated: `{now}`",
        "",
        "---",
        "",
        "## 🎯 Executive Summary",
        "",
        f"| Metric | Count |",
        f"|---|---|",
        f"| **Overall Status** | {overall} |",
        f"| Files Scanned | {scan_stats.get('files_scanned', '—')} |",
        f"| 🔴 Critical | {critical} |",
        f"| 🟠 High | {high} |",
        f"| 🟡 Medium | {medium} |",
        f"| 🔵 Low | {low} |",
        f"| **Total Findings** | **{total}** |",
        "",
        "---",
        "",
    ]

    if not all_findings:
        lines += [
            "## ✅ No Security Issues Found",
            "",
            "The automated scan found no security issues in this repository.",
            "> Note: Automated scans are not a substitute for manual security review.",
            "",
        ]
    else:
        lines += [
            "## 📋 Findings",
            "",
            "| # | Severity | File | Line | Description | Excerpt |",
            "|---|---|---|---|---|---|",
        ]
        for i, f in enumerate(all_findings, 1):
            line_ref = f"`:{f['line']}`" if f["line"] else ""
            excerpt = f"`{f['excerpt'][:60]}`" if f["excerpt"] else "—"
            lines.append(
                f"| {i} | {f['severity']} | `{f['file']}`{line_ref} "
                f"| {f['line'] or '—'} | {f['description']} | {excerpt} |"
            )
        lines += [""]

    lines += [
        "---",
        "",
        "## 🛡️ Scan Coverage",
        "",
        f"| Check | Status |",
        f"|---|---|",
        f"| Secret / credential patterns | ✅ Scanned |",
        f"| Security-related TODO/FIXME annotations | ✅ Scanned |",
        f"| Unpinned GitHub Actions | ✅ Scanned |",
        f"| Sensitive file names | ✅ Scanned |",
        "",
        "---",
        "",
        "## 🔗 Resources",
        "",
        "- [FLLC Cyber Arsenal](https://www.fllc.net/cyber-arsenal)",
        "- [CyberWorld Security Wiki](https://github.com/Personfu/CYBERWORLDSOURCECODELITE/wiki)",
        "- [GitHub Security Advisories](https://github.com/Personfu/CYBERWORLDSOURCECODELITE/security/advisories)",
        "",
        "---",
        "",
        "> ⚠️ This is an automated scan. Results may include false positives.",
        "> Always perform a manual review for critical findings.",
        "",
        "*CyberWorld Automation — Powered by FLLC Enterprise IT Solutions* ⚡",
    ]
    return "\n".join(lines)


def main() -> None:
    token = os.environ.get("GITHUB_TOKEN") or os.environ.get("REPORTS_TOKEN")
    if not token:
        print("❌  GITHUB_TOKEN not set", file=sys.stderr)
        sys.exit(1)

    repo_root = find_repo_root()
    print(f"🔍  Security scanning: {repo_root}")

    files_scanned = sum(1 for _ in _iter_files(repo_root))
    print(f"📁  Files to scan: {files_scanned}")

    print("  → Scanning for secrets...")
    secret_findings = scan_secrets(repo_root)
    print(f"     {len(secret_findings)} findings")

    print("  → Scanning for security TODOs...")
    todo_findings = scan_security_todos(repo_root)
    print(f"     {len(todo_findings)} findings")

    print("  → Checking unpinned GitHub Actions...")
    action_findings = scan_unpinned_actions(repo_root)
    print(f"     {len(action_findings)} findings")

    print("  → Checking sensitive file names...")
    file_findings = scan_sensitive_files(repo_root)
    print(f"     {len(file_findings)} findings")

    all_findings = secret_findings + todo_findings + action_findings + file_findings
    scan_stats = {"files_scanned": files_scanned}

    print(f"⚠️   Total findings: {len(all_findings)}")
    report = build_report(all_findings, scan_stats)

    date_slug = datetime.now(timezone.utc).strftime("%Y-%m-%d")
    push_report(
        f"security-audit/security-audit-{date_slug}.md",
        report,
        f"Security audit {date_slug}",
    )
    push_report("security-audit/latest.md", report, "Update latest security audit")

    # Discord alert if critical/high findings
    critical = sum(1 for f in all_findings if f["severity"] == SEVERITY_CRITICAL)
    high = sum(1 for f in all_findings if f["severity"] == SEVERITY_HIGH)
    webhook = os.environ.get("DISCORD_WEBHOOK")
    if webhook and (critical > 0 or high > 0):
        import json
        import urllib.request
        msg = (
            f"🔐 **CyberWorld Security Alert**\n"
            f"🔴 Critical: {critical}  🟠 High: {high}\n"
            f"📋 Full report: https://github.com/Personfu/REPORTS/blob/main/security-audit/latest.md"
        )
        payload = json.dumps({"content": msg, "username": "CyberWorld Security"}).encode()
        req = urllib.request.Request(
            webhook, data=payload,
            headers={"Content-Type": "application/json", "User-Agent": "CyberWorld-Automation/1.0"},
            method="POST",
        )
        try:
            with urllib.request.urlopen(req):
                print("📣  Discord security alert sent")
        except Exception as e:
            print(f"⚠️  Discord notify failed: {e}", file=sys.stderr)

    print("✅  Security audit complete.")

    # Exit non-zero if critical findings (to fail the CI job)
    if critical > 0:
        print("🔴  CRITICAL findings detected — review required!", file=sys.stderr)
        sys.exit(2)


if __name__ == "__main__":
    main()
