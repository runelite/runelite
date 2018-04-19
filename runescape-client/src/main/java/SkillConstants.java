import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
public class SkillConstants
{
   @ObfuscatedName("k")
   public static final boolean[] ENABLED_SKILLS;
   @ObfuscatedName("t")
   public static int[] SKILL_EXPERIENCE;
   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "[Lld;"
   )
   @Export("crossSprites")
   static SpritePixels[] crossSprites;

   static {
      ENABLED_SKILLS = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      SKILL_EXPERIENCE = new int[99];
      int value = 0;

      for(int index = 0; index < 99; ++index) {
         int level = index + 1;
         int var3 = (int)((double)level + 300.0D * Math.pow(2.0D, (double)level / 7.0D));
         value += var3;
         SKILL_EXPERIENCE[index] = value / 4;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1602991858"
   )
   public static int method4500(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }
}
