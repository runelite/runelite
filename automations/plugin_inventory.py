"""
plugin_inventory.py — CyberWorld Plugin Scanner
Walks the CyberWorld client plugin directory, generates a full markdown
inventory table, and pushes it to Personfu/REPORTS.

Env vars:
    GITHUB_TOKEN   — PAT with write access to REPORTS
    GITHUB_WORKSPACE — automatically set in GitHub Actions (repo root)
"""

import os
import sys
import re
from pathlib import Path
from datetime import datetime, timezone
from report_pusher import push_report

# Relative to repo root
PLUGINS_SUBPATH = "runelite-client/src/main/java/net/runelite/client/plugins"

# Annotations we look for inside plugin .java files
PLUGIN_DESCRIPTOR_PATTERN = re.compile(
    r'@PluginDescriptor\s*\([^)]*name\s*=\s*"([^"]+)"[^)]*\)',
    re.DOTALL,
)
DESCRIPTION_PATTERN = re.compile(
    r'description\s*=\s*"([^"]+)"',
)
TAGS_PATTERN = re.compile(
    r'tags\s*=\s*\{([^}]+)\}',
)


def find_repo_root() -> Path:
    workspace = os.environ.get("GITHUB_WORKSPACE")
    if workspace:
        return Path(workspace)
    # Fall back: walk up from this file
    current = Path(__file__).resolve()
    for parent in [current.parent.parent, current.parent.parent.parent]:
        if (parent / "runelite-client").exists():
            return parent
    raise RuntimeError("Cannot locate repo root — set GITHUB_WORKSPACE")


def parse_plugin_file(java_file: Path) -> dict | None:
    """Extract plugin metadata from a Java file."""
    try:
        text = java_file.read_text(encoding="utf-8", errors="ignore")
    except OSError:
        return None

    name_match = PLUGIN_DESCRIPTOR_PATTERN.search(text)
    if not name_match:
        return None

    name = name_match.group(1)
    desc_match = DESCRIPTION_PATTERN.search(text)
    description = desc_match.group(1) if desc_match else "—"

    tags_match = TAGS_PATTERN.search(text)
    if tags_match:
        raw_tags = tags_match.group(1)
        tags = [t.strip().strip('"') for t in raw_tags.split(",") if t.strip().strip('"')]
    else:
        tags = []

    # Try to detect if plugin has a config
    has_config = "implements PluginConfig" in text or "@ConfigGroup" in text
    # Try to detect overlay usage
    has_overlay = "Overlay" in text

    return {
        "name": name,
        "description": description,
        "tags": tags,
        "has_config": has_config,
        "has_overlay": has_overlay,
        "file": java_file.name,
        "dir": java_file.parent.name,
    }


def scan_plugins(repo_root: Path) -> list[dict]:
    plugins_dir = repo_root / PLUGINS_SUBPATH
    if not plugins_dir.exists():
        print(f"⚠️  Plugins directory not found: {plugins_dir}", file=sys.stderr)
        return []

    plugins = []
    for java_file in sorted(plugins_dir.rglob("*Plugin.java")):
        meta = parse_plugin_file(java_file)
        if meta:
            plugins.append(meta)

    return plugins


def build_report(plugins: list[dict]) -> str:
    now = datetime.now(timezone.utc).strftime("%Y-%m-%d %H:%M:%S UTC")
    total = len(plugins)
    with_config = sum(1 for p in plugins if p["has_config"])
    with_overlay = sum(1 for p in plugins if p["has_overlay"])

    lines = [
        "# 🔌 CyberWorld Plugin Inventory",
        f"> Generated: `{now}`  |  Total plugins: **{total}**",
        "",
        "---",
        "",
        "## 📊 Summary",
        "",
        f"| Metric | Count |",
        f"|---|---|",
        f"| Total Plugins | **{total}** |",
        f"| Plugins with Config Panel | {with_config} |",
        f"| Plugins with Overlay | {with_overlay} |",
        "",
        "---",
        "",
        "## 🗂️ Full Plugin List",
        "",
        "| # | Plugin Name | Description | Tags | Config | Overlay | Source Dir |",
        "|---|---|---|---|---|---|---|",
    ]

    for i, p in enumerate(plugins, 1):
        tags_str = ", ".join(f"`{t}`" for t in p["tags"]) if p["tags"] else "—"
        config_icon = "✅" if p["has_config"] else "—"
        overlay_icon = "✅" if p["has_overlay"] else "—"
        lines.append(
            f"| {i} | **{p['name']}** | {p['description']} "
            f"| {tags_str} | {config_icon} | {overlay_icon} | `{p['dir']}/` |"
        )

    lines += [
        "",
        "---",
        "",
        "## 🏷️ Tag Cloud",
        "",
    ]

    # Build tag frequency
    tag_freq: dict[str, int] = {}
    for p in plugins:
        for t in p["tags"]:
            tag_freq[t] = tag_freq.get(t, 0) + 1

    if tag_freq:
        sorted_tags = sorted(tag_freq.items(), key=lambda x: -x[1])
        tag_lines = []
        for tag, count in sorted_tags[:30]:
            tag_lines.append(f"`{tag}` ({count})")
        lines.append("  ".join(tag_lines))
    else:
        lines.append("_No tags found._")

    lines += [
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

    repo_root = find_repo_root()
    print(f"🔍  Scanning plugins in: {repo_root / PLUGINS_SUBPATH}")

    plugins = scan_plugins(repo_root)
    print(f"📦  Found {len(plugins)} plugins")

    report = build_report(plugins)

    date_slug = datetime.now(timezone.utc).strftime("%Y-%m-%d")
    push_report(
        f"plugin-inventory/plugin-inventory-{date_slug}.md",
        report,
        f"Plugin inventory {date_slug}",
    )
    push_report("plugin-inventory/latest.md", report, "Update latest plugin inventory")

    print("✅  Plugin inventory complete.")


if __name__ == "__main__":
    main()
