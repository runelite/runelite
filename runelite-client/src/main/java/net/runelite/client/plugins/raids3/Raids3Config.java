package net.runelite.client.plugins.raids3;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup("1Up Raids3")
public interface Raids3Config extends Config {
  @ConfigSection(
      name = "Overlay Settings",
      description = "",
      position = 1
  )
  String OverlaySection = "OverlaySection";
  @ConfigSection(
      name = "Prayer Settings",
      description = "Prayer Settings",
      position = 7
  )
  String PrayerOverlaySection = "PrayerOverlaySection";
  @ConfigSection(
      name = "Boss Weakness Overlay",
      description = "Boss Weakness Overlay Settings",
      position = 5
  )
  String BossWeaknessOverlaySection = "BossWeaknessOverlaySection";
  @ConfigSection(
      name = "Akkha",
      description = "Akkha Settings",
      position = 17
  )
  String AkkhaSection = "AkkhaSection";
  @ConfigSection(
      name = "Ba-Ba",
      description = "Ba-Ba Settings",
      position = 30
  )
  String BabaSection = "BabaSection";
  @ConfigSection(
      name = "Kephri",
      description = "Settings for Kephri",
      position = 38
  )
  String KephriRoomSection = "KephriRoomSection";
  @ConfigSection(
      name = "Warden",
      description = "Settings for Warden",
      position = 41
  )
  String WardenRoomSection = "WardenRoomSection";
  @ConfigSection(
      name = "Puzzle Room",
      description = "Settings for Puzzle Room",
      position = 59
  )
  String PuzzleRoomSection = "PuzzleRoomSection";
  @ConfigSection(
      name = "Baboon Room",
      description = "Settings for Baboon Room",
      position = 62
  )
  String BaboonRoomSection = "BaboonRoomSection";
  @ConfigSection(
      name = "Mirror Room",
      description = "Mirror Room Settings",
      position = 65
  )
  String MirrorRoomSection = "MirrorRoomSection";
  @ConfigSection(
      name = "Zebak",
      description = "Zebak Settings",
      position = 75
  )
  String ZebakSection = "ZebakSection";
  @ConfigSection(
      name = "Invocations",
      description = "Invocations Settings",
      position = 76
  )
  String InvocationsSection = "InvocationsSection";
  @ConfigSection(
      name = "[Coming Soon] Gear Swapper",
      description = "Gear Swapper Settings",
      position = 81
  )
  String GearSwapper = "GearSwapper";
  @ConfigSection(
      name = "Beta Settings",
      description = "",
      position = 82
  )
  String BetaSettings = "BetaSettings";

  @ConfigItem(
      position = 2,
      keyName = "AttackTickOverlayType",
      name = "Boss Attack Tick",
      description = "Displays boss tick countdown. *Working Bosses* (ZEBAK)",
      section = "OverlaySection"
  )
  default TickOverlayDisplayType AttackTickOverlayType() {
    return TickOverlayDisplayType.Off;
  }

  @Range(
      min = 50,
      max = 225
  )
  @ConfigItem(
      position = 3,
      keyName = "OverlayAlpha",
      name = "Overlay Alpha",
      description = "Alpha value for overlay colors.(50-225)",
      section = "OverlaySection"
  )
  default int OverlayAlpha() {
    return 100;
  }

  @Range(
      max = 100
  )
  @ConfigItem(
      position = 4,
      keyName = "OverlayBrightness",
      name = "Overlay Brightness",
      description = "Brightness value for overlay colors.(0-100)",
      section = "OverlaySection"
  )
  default int OverlayBrightness() {
    return 75;
  }

  @ConfigItem(
      position = 5,
      keyName = "ProjectileTicks",
      name = "Projectile Ticks",
      description = "Displays ticks for projectiles and ground attacks at the target tiles.",
      section = "OverlaySection"
  )
  default boolean ProjectileTicks() {
    return true;
  }

  @ConfigItem(
      position = 6,
      keyName = "TickFontType",
      name = "Tick Font Type",
      description = "Displays ticks for projectiles and ground attacks at the target tiles.",
      section = "OverlaySection"
  )
  default FontTypes TickFontType() {
    return FontTypes.REGULAR;
  }

  @ConfigItem(
      position = 7,
      keyName = "TickFontSize",
      name = "Tick Font Size",
      description = "Ground tile overlay tick font size.",
      section = "OverlaySection"
  )
  default int TickFontSize() {
    return 9;
  }

  @ConfigItem(
      position = 8,
      keyName = "BorderColor",
      name = "Border Color",
      description = "Ground tile overlay border color.",
      section = "OverlaySection"
  )
  default Color BorderColor() {
    return new Color(-16777216, true);
  }

  @ConfigItem(
      position = 2,
      keyName = "prayerOverlay",
      name = "Prayer Overlay",
      description = "prayerOverlay",
      section = "PrayerOverlaySection"
  )
  default boolean PrayerOverlay() {
    return true;
  }

  @Alpha
  @ConfigItem(
      position = 3,
      keyName = "WrongColor",
      name = "Wrong Prayer",
      description = "",
      section = "PrayerOverlaySection"
  )
  default Color WrongColor() {
    return new Color(-1929698802, true);
  }

  @Alpha
  @ConfigItem(
      position = 4,
      keyName = "CorrectColor",
      name = "Correct Prayer",
      description = "",
      section = "PrayerOverlaySection"
  )
  default Color CorrectColor() {
    return new Color(-1943078130, true);
  }

  @ConfigItem(
      position = 1,
      keyName = "HighlightWeakness",
      name = "Highlight Boss Weakness",
      description = "Highlight Weakness",
      section = "BossWeaknessOverlaySection"
  )
  default boolean HighlightWeakness() {
    return true;
  }

  @Alpha
  @ConfigItem(
      position = 2,
      keyName = "RangeWeaknessColor",
      name = "Range Weakness",
      description = "Range Weakness Color",
      section = "BossWeaknessOverlaySection"
  )
  default Color RangeWeaknessColor() {
    return new Color(-16725983, true);
  }

  @Alpha
  @ConfigItem(
      position = 3,
      keyName = "MagicWeaknessColor",
      name = "Magic Weakness",
      description = "Magic Weakness Color",
      section = "BossWeaknessOverlaySection"
  )
  default Color MagicWeaknessColor() {
    return new Color(-16753208, true);
  }

  @Alpha
  @ConfigItem(
      position = 4,
      keyName = "MeleeWeaknessColor",
      name = "Melee Weakness",
      description = "Melee Weakness Color",
      section = "BossWeaknessOverlaySection"
  )
  default Color MeleeWeaknessColor() {
    return new Color(-3669969, true);
  }

  @ConfigItem(
      position = 18,
      keyName = "MemoryBlast",
      name = "Highlight Memory Blast",
      description = "Highlight memory blast safe tile section.",
      section = "AkkhaSection"
  )
  default boolean MemoryBlast() {
    return true;
  }

  @ConfigItem(
      position = 20,
      keyName = "ShowUnstableOrbPaths",
      name = "Unstable Orb Paths",
      description = "",
      section = "AkkhaSection"
  )
  default boolean ShowUnstableOrbPaths() {
    return false;
  }

  @ConfigItem(
      position = 21,
      keyName = "ShowUnstableOrbDistance",
      name = "Unstable Orb Distance",
      description = "Show Show Unstable Orb Distance Values.",
      section = "AkkhaSection"
  )
  default boolean ShowUnstableOrbDistance() {
    return false;
  }

  @ConfigItem(
      position = 22,
      keyName = "HighlightLowDangerTile",
      name = "Highlight Low Danger Tile",
      description = "Highlight Low Danger Tile during Unstable Orb Phase",
      section = "AkkhaSection"
  )
  default boolean HighlightLowDangerTile() {
    return true;
  }

  @ConfigItem(
      position = 23,
      keyName = "HighlightMidDangerTile",
      name = "Highlight Mid Danger Tile",
      description = "Highlight Mid Danger Tile during Unstable Orb Phase",
      section = "AkkhaSection"
  )
  default boolean HighlightMidDangerTile() {
    return true;
  }

  @ConfigItem(
      position = 24,
      keyName = "HighlightMaxDangerTile",
      name = "Highlight Max Danger Tile",
      description = "Highlight Max Danger Tile during Unstable Orb Phase",
      section = "AkkhaSection"
  )
  default boolean HighlightMaxDangerTile() {
    return true;
  }

  @Alpha
  @ConfigItem(
      position = 25,
      keyName = "TileColor",
      name = "Tile Color",
      description = "",
      section = "AkkhaSection"
  )
  default Color TileColor() {
    return new Color(-364774642, true);
  }

  @Alpha
  @ConfigItem(
      position = 26,
      keyName = "NextTileColor",
      name = "Next Tile Color",
      description = "",
      section = "AkkhaSection"
  )
  default Color NextTileColor() {
    return new Color(-353398186, true);
  }

  @Alpha
  @ConfigItem(
      position = 27,
      keyName = "UnstableOrbFar",
      name = "Unstable Orb Far",
      description = "Unstable orb is atleast 7 tiles away",
      section = "AkkhaSection"
  )
  default Color UnstableOrbFar() {
    return new Color(-1086194930, true);
  }

  @Alpha
  @ConfigItem(
      position = 28,
      keyName = "UnstableOrbMedium",
      name = "Unstable Orb Medium",
      description = "Unstable orb is atleast 3 tiles away",
      section = "AkkhaSection"
  )
  default Color UnstableOrbMedium() {
    return new Color(-1073752832, true);
  }

  @Alpha
  @ConfigItem(
      position = 29,
      keyName = "UnstableOrbClose",
      name = "Unstable Orb Close",
      description = "Unstable Orb is less than 3 tiles away.",
      section = "AkkhaSection"
  )
  default Color UnstableOrbClose() {
    return new Color(-1073806275, true);
  }

  @ConfigItem(
      position = 31,
      keyName = "HighlightBoulder",
      name = "Highlight Boulder",
      description = "Highlight Ba-Ba Rolling Boulder",
      section = "BabaSection"
  )
  default boolean HighlightBoulder() {
    return true;
  }

  @ConfigItem(
      position = 32,
      keyName = "HighlightCenterShadowTile",
      name = "Highlight Shockwave Tiles",
      description = "Highlights Shockwave tiles",
      section = "BabaSection"
  )
  default boolean HighlightShockwave() {
    return true;
  }

  @ConfigItem(
      position = 33,
      keyName = "MindTheGap",
      name = "Mind The Gap",
      description = "Mind The Gap",
      section = "BabaSection"
  )
  default boolean MindTheGap() {
    return false;
  }

  @ConfigItem(
      position = 34,
      keyName = "BoulderColor",
      name = "Boulder Color",
      description = "Highlight Ba-Ba Rolling Boulder",
      section = "BabaSection"
  )
  default Color BoulderColor() {
    return new Color(-366550017, true);
  }

  @Alpha
  @ConfigItem(
      position = 35,
      keyName = "ShadowTileColor",
      name = "Shadow Tile Color",
      description = "Shadow Tile Color",
      section = "BabaSection"
  )
  default Color ShadowTileColor() {
    return new Color(1272446976, true);
  }

  @Alpha
  @ConfigItem(
      position = 36,
      keyName = "MindTheGapWarning1Color",
      name = "First Warning",
      description = "Mind the Gap first warning.",
      section = "BabaSection"
  )
  default Color MindTheGapWarning1Color() {
    return new Color(-353384896, true);
  }

  @Alpha
  @ConfigItem(
      position = 37,
      keyName = "MindTheGapWarning2Color  ",
      name = "Final Warning",
      description = "Mind the Gap final warning.",
      section = "BabaSection"
  )
  default Color MindTheGapWarning2Color() {
    return new Color(1272446976, true);
  }

  @ConfigItem(
      position = 7,
      keyName = "HightlightKephriFireBall",
      name = "Hightlight FireBall",
      description = "Highlight Kephri's fireball attack.",
      section = "KephriRoomSection"
  )
  default boolean HightlightKephriFireBall() {
    return true;
  }

  @Alpha
  @ConfigItem(
      position = 8,
      keyName = "KephriFireballColor",
      name = "Fireball Tile Color",
      description = "Fireball Tile Color",
      section = "KephriRoomSection"
  )
  default Color KephriFireballColor() {
    return new Color(-1359010266, true);
  }

  @ConfigItem(
      position = 42,
      keyName = "HighlightWardenUnstableBolt",
      name = "Highlight Unstable Bolt Tiles",
      description = "Highlights Unstable Bolt attack tiles.",
      section = "WardenRoomSection"
  )
  default boolean HighlightWardenUnstableBolt() {
    return true;
  }

  @ConfigItem(
      position = 43,
      keyName = "HighlightWardenSlamTiles",
      name = "Highlight Slam Tiles",
      description = "Highlights slam attack tiles.",
      section = "WardenRoomSection"
  )
  default boolean HighlightWardenSlamTiles() {
    return true;
  }

  @Range(
      min = 20,
      max = 100
  )
  @ConfigItem(
      position = 44,
      keyName = "WardenSlamAlpha",
      name = "Slam Overlay Alpha",
      description = "Alpha value for slam attack overlay. (20-100)",
      section = "WardenRoomSection"
  )
  default int WardenSlamAlpha() {
    return 50;
  }

  @ConfigItem(
      position = 45,
      keyName = "HighlightWardenWindmillBeam",
      name = "Highlight Windmill Beam Tiles",
      description = "Highlights windmill beam attack tiles.",
      section = "WardenRoomSection"
  )
  default boolean HighlightWardenWindmillBeam() {
    return true;
  }

  @ConfigItem(
      position = 46,
      keyName = "HighlightWardenLightning",
      name = "Highlight Lightning Skull Tiles",
      description = "Highlights lightning attack tiles.",
      section = "WardenRoomSection"
  )
  default boolean HighlightWardenLightning() {
    return true;
  }

  @ConfigItem(
      position = 47,
      keyName = "HighlightBabaBoulder",
      name = "Highlight Baba Boulder",
      description = "Highlight Baba boulder during phase3.",
      section = "WardenRoomSection"
  )
  default boolean HighlightBabaBoulder() {
    return true;
  }

  @ConfigItem(
      position = 48,
      keyName = "HighlightWardenImprisonment",
      name = "Highlight Imprisonment",
      description = "Highlights imprisonment projectile target tile.",
      section = "WardenRoomSection"
  )
  default boolean HighlightWardenImprisonment() {
    return true;
  }

  @Alpha
  @ConfigItem(
      position = 49,
      keyName = "WardenImprisonmentTileColor",
      name = "Imprisonment",
      description = "Imprisonment Tile Color",
      section = "WardenRoomSection"
  )
  default Color WardenImprisonmentTileColor() {
    return new Color(-436207617, true);
  }

  @Alpha
  @ConfigItem(
      position = 50,
      keyName = "WardenWindmillDanger",
      name = "Windmill Beam",
      description = "Warden Windmill Danger Color",
      section = "WardenRoomSection"
  )
  default Color WardenWindmillDanger() {
    return new Color(-788594166, true);
  }

  @Alpha
  @ConfigItem(
      position = 51,
      keyName = "WardenWindmillSafe",
      name = "Windmill Warning",
      description = "Warden Windmill Safe Color",
      section = "WardenRoomSection"
  )
  default Color WardenWindmillSafe() {
    return new Color(-788540158, true);
  }

  @ConfigItem(
      position = 52,
      keyName = "WardenLightningTileColor",
      name = "Lightning Skull",
      description = "Fireball Tile Color",
      section = "WardenRoomSection"
  )
  default Color WardenLightningTileColor() {
    return new Color(-802750465, true);
  }

  @ConfigItem(
      position = 53,
      keyName = "WardenLightningCenterTileColor",
      name = "Lightning Skull Center",
      description = "Lightning Center Tile",
      section = "WardenRoomSection"
  )
  default Color WardenLightningCenterTileColor() {
    return new Color(-2114187705, true);
  }

  @Alpha
  @ConfigItem(
      position = 54,
      keyName = "WardenSlamSafeColor",
      name = "Warden Slam Safe Tiles",
      description = "Warden slam safe tiles color.",
      section = "WardenRoomSection"
  )
  default Color WardenSlamSafeColor() {
    return new Color(2030370597, true);
  }

  @Alpha
  @ConfigItem(
      position = 55,
      keyName = "WardenWave1UnstableBoltColor",
      name = "Wave1 Bolt",
      description = "Warden Wave1 Unstable Bolt color.",
      section = "WardenRoomSection"
  )
  default Color WardenWave1UnstableBoltColor() {
    return new Color(-1577122755, true);
  }

  @Alpha
  @ConfigItem(
      position = 56,
      keyName = "WardenWave2UnstableBoltColor",
      name = "Wave2 Bolt",
      description = "Warden Wave2 Unstable Bolt color.",
      section = "WardenRoomSection"
  )
  default Color WardenWave2UnstableBoltColor() {
    return new Color(-1577098236, true);
  }

  @Alpha
  @ConfigItem(
      position = 57,
      keyName = "WardenWave3UnstableBoltColor",
      name = "Wave3 Bolt",
      description = "Warden Wave3 Unstable Bolt color.",
      section = "WardenRoomSection"
  )
  default Color WardenWave3UnstableBoltColor() {
    return new Color(-1577451757, true);
  }

  @ConfigItem(
      position = 58,
      keyName = "BabaBoulderColor",
      name = "Baba Boulder",
      description = "Baba boulder tile color.",
      section = "WardenRoomSection"
  )
  default Color BabaBoulderColor() {
    return new Color(-1577122755, true);
  }

  @ConfigItem(
      position = 60,
      keyName = "HighlightFallingBoulders",
      name = "Highlight Falling Boulders",
      description = "Highlight Falling Boulders",
      section = "PuzzleRoomSection"
  )
  default boolean HighlightFallingBoulders() {
    return true;
  }

  @ConfigItem(
      position = 61,
      keyName = "FallingBoulderColor",
      name = "Falling Boulder",
      description = "Falling boulder color",
      section = "PuzzleRoomSection"
  )
  default Color FallingBoulderColor() {
    return new Color(-1577122755, true);
  }

  @ConfigItem(
      position = 2,
      keyName = "ShowWeakness",
      name = "Show Weakness",
      description = "Show Baboon Weakness",
      section = "BaboonRoomSection"
  )
  default boolean ShowWeakness() {
    return true;
  }

  @ConfigItem(
      position = 66,
      keyName = "BeamTickOverlay",
      name = "Beam Tick Overlay",
      description = "Beam Tick Overlay",
      section = "MirrorRoomSection"
  )
  default boolean BeamTickOverlay() {
    return true;
  }

  @ConfigItem(
      position = 67,
      keyName = "ShowTick",
      name = "Show Tick",
      description = "Show Tick",
      section = "MirrorRoomSection"
  )
  default boolean ShowTick() {
    return true;
  }

  @ConfigItem(
      position = 68,
      keyName = "DisableFontScaling",
      name = "Disable Font Scaling",
      description = "Disable Font Scaling",
      section = "MirrorRoomSection"
  )
  default boolean DisableFontScaling() {
    return true;
  }

  @ConfigItem(
      position = 69,
      keyName = "NumberColor",
      name = "Number Color",
      description = "Number Color",
      section = "MirrorRoomSection"
  )
  default Color NumberColor() {
    return new Color(-1, true);
  }

  @ConfigItem(
      position = 70,
      keyName = "BeamDangerColor",
      name = "Damage Color",
      description = "Beam Damage Color",
      section = "MirrorRoomSection"
  )
  default Color BeamDamageColor() {
    return new Color(-352377306, true);
  }

  @ConfigItem(
      position = 71,
      keyName = "BeamWarningColor",
      name = "Warning Color",
      description = "Beam Warning Color",
      section = "MirrorRoomSection"
  )
  default Color BeamWarningColor() {
    return new Color(-353398186, true);
  }

  @ConfigItem(
      position = 72,
      keyName = "BeamSafeColor",
      name = "Safe Color",
      description = "Beam Safe Color",
      section = "MirrorRoomSection"
  )
  default Color BeamSafeColor() {
    return new Color(-1943078130, true);
  }

  @ConfigItem(
      position = 73,
      keyName = "FontType",
      name = "Font Type",
      description = "Font Type",
      section = "MirrorRoomSection"
  )
  default FontTypes FontType() {
    return FontTypes.REGULAR;
  }

  @ConfigItem(
      position = 1,
      keyName = "feelingSpecial",
      name = "Feeling Special?",
      description = "The Memory Blast attack will only provide two ticks for players to move between safe quadrants.",
      section = "InvocationsSection"
  )
  default boolean feelingSpecial() {
    return false;
  }

  @ConfigItem(
      position = 2,
      keyName = "DoubleTrouble",
      name = "Double Trouble",
      description = "Akkha will perform two special attacks at once.",
      section = "InvocationsSection"
  )
  default boolean DoubleTrouble() {
    return false;
  }

  @ConfigItem(
      position = 3,
      keyName = "ShakingThingsUp",
      name = "Shaking Things Up",
      description = "The shockwave from Ba-Ba's slam attack has its AoE increased from 3x3 (+1 tile on all center cardinal directions) to 5x5 (+1 tile on all center cardinal directions).",
      section = "InvocationsSection"
  )
  default boolean ShakingThingsUp() {
    return false;
  }

  @ConfigItem(
      position = 4,
      keyName = "AerialAssault",
      name = "Aerial Assault",
      description = "Kephri's auto-attack will do more damage, and her attack range will increase from a single tile to a 3x3 AoE. Also applies to bomber scarabs.",
      section = "InvocationsSection"
  )
  default boolean AerialAssault() {
    return false;
  }

  @ConfigItem(
      position = 5,
      keyName = "UpsetStomach",
      name = "Upset Stomach",
      description = "Acid can now splatter in a 5x5 AoE whereas the water from jugs is reduced to a 3x3 AoE.",
      section = "InvocationsSection"
  )
  default boolean UpsetStomach() {
    return false;
  }

  @ConfigItem(
      position = 6,
      keyName = "SpeedBoostInvocation",
      name = "Raid Speed",
      description = "",
      section = "InvocationsSection"
  )
  default SpeedInvocation SpeedInvocation() {
    return SpeedInvocation.Normal;
  }

  @ConfigItem(
      position = 1,
      keyName = "BabaBoulderTicks",
      name = "Baba Boulder Ticks",
      description = "",
      section = "BetaSettings",
      hidden = true
  )
  default int BabaBoulderTicks() {
    return 6;
  }

  @ConfigItem(
      position = 2,
      keyName = "WardenProjectileTicks",
      name = "Warden Projectile Ticks",
      description = "",
      section = "BetaSettings",
      hidden = true
  )
  default int WardenProjectileTicks() {
    return 4;
  }

  @ConfigItem(
      position = 86,
      keyName = "butterflyDistance1",
      name = "slamAttackSpeed",
      description = "butterflyDistance1",
      hidden = true
  )
  default int butterflyDistance1() {
    return 4;
  }

  @ConfigItem(
      position = 87,
      keyName = "butterflyDistance2",
      name = "WardenBabaBoulderTick",
      description = "butterflyDistance2",
      hidden = true
  )
  default double butterflyDistance2() {
    return 4.0D;
  }

  @ConfigItem(
      position = 88,
      keyName = "butterflyDistance3",
      name = "butterflyDistance3",
      description = "butterflyDistance3",
      hidden = true
  )
  default int butterflyDistance3() {
    return 4;
  }

  @ConfigItem(
      position = 89,
      keyName = "butterflyDistance4",
      name = "butterflyDistance4",
      description = "butterflyDistance4",
      hidden = true
  )
  default int butterflyDistance4() {
    return 4;
  }

}