import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1615186331
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1162840707
   )
   int field687;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1558280271
   )
   int field688;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1777525983
   )
   @Export("health")
   int health;
   @ObfuscatedName("qx")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "617537373"
   )
   void method638(int var1, int var2, int var3, int var4) {
      this.field687 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field688 = var4;
   }

   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "(LWidget;II)Ljava/lang/String;",
      garbageValue = "964598355"
   )
   static String method640(Widget var0, int var1) {
      return !class44.method883(class196.method3614(var0), var1) && null == var0.field2274?null:(null != var0.actions && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZB)I",
      garbageValue = "94"
   )
   static int method641(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method646()?(var1.method646()?0:1):(var1.method646()?-1:0)):(var2 == 5?(var0.method678()?(var1.method678()?0:1):(var1.method678()?-1:0)):(var2 == 6?(var0.method645()?(var1.method645()?0:1):(var1.method645()?-1:0)):(var2 == 7?(var0.method668()?(var1.method668()?0:1):(var1.method668()?-1:0)):var0.id - var1.id)))));
      }
   }

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field687 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field688 = var4;
   }
}
