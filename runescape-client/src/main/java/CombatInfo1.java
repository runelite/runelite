import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 165766523
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1394771333
   )
   @Export("health")
   int health;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = 1543925975
   )
   protected static int field682;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1395825023
   )
   static int field683;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1626461009
   )
   int field684;
   @ObfuscatedName("mb")
   static SpritePixels field686;
   @ObfuscatedName("dx")
   @Export("region")
   static Region region;
   @ObfuscatedName("m")
   static int[][] field688;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1430906969
   )
   int field690;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1462660177"
   )
   void method591(int var1, int var2, int var3, int var4) {
      this.field684 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field690 = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)LScript;",
      garbageValue = "1031029287"
   )
   static Script method593(int var0) {
      Script var1 = (Script)Script.field968.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Projectile.indexScripts.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new Script();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.readInt();
            var1.localIntCount = var3.readUnsignedShort();
            var1.localStringCount = var3.readUnsignedShort();
            var1.intStackCount = var3.readUnsignedShort();
            var1.stringStackCount = var3.readUnsignedShort();
            var3.offset = 0;
            var3.method2922();
            var1.instructions = new int[var4];
            var1.intOperands = new int[var4];
            var1.stringOperands = new String[var4];

            int var5;
            for(int var6 = 0; var3.offset < var3.payload.length - 12; var1.instructions[var6++] = var5) {
               var5 = var3.readUnsignedShort();
               if(var5 == 3) {
                  var1.stringOperands[var6] = var3.readString();
               } else if(var5 < 100 && var5 != 21 && var5 != 38 && var5 != 39) {
                  var1.intOperands[var6] = var3.readInt();
               } else {
                  var1.intOperands[var6] = var3.readUnsignedByte();
               }
            }

            Script.field968.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "682289264"
   )
   static int method594(World var0, World var1, int var2, boolean var3) {
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
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method599()?(var1.method599()?0:1):(var1.method599()?-1:0)):(var2 == 5?(var0.method597()?(var1.method597()?0:1):(var1.method597()?-1:0)):(var2 == 6?(var0.method598()?(var1.method598()?0:1):(var1.method598()?-1:0)):(var2 == 7?(var0.method632()?(var1.method632()?0:1):(var1.method632()?-1:0)):var0.id - var1.id)))));
      }
   }

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field684 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field690 = var4;
   }
}
