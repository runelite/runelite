import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 1943451743
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;

   @ObfuscatedSignature(
      signature = "(Liv;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1735095159"
   )
   void method1695(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3567(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3569()) {
         ++var6;
         if(var7.field1273 == var1) {
            var7.method1546(var1, var2, var3, var4);
            return;
         }

         if(var7.field1273 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3564(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3576(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3567().unlink();
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IS)Lcs;",
      garbageValue = "256"
   )
   CombatInfo1 method1696(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3567();
      if(var2 != null && var2.field1273 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3569(); var3 != null && var3.field1273 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3569()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3363 + var2.field1270 + var2.field1273 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "16"
   )
   boolean method1697() {
      return this.combatInfo1.method3570();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "114060152"
   )
   static final void method1702() {
      short var0 = 256;
      int var1;
      if(class93.field1427 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class93.field1427 > 768) {
               class88.field1365[var1] = PacketBuffer.method3425(class13.field276[var1], class93.field1441[var1], 1024 - class93.field1427);
            } else if(class93.field1427 > 256) {
               class88.field1365[var1] = class93.field1441[var1];
            } else {
               class88.field1365[var1] = PacketBuffer.method3425(class93.field1441[var1], class13.field276[var1], 256 - class93.field1427);
            }
         }
      } else if(class93.field1431 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class93.field1431 > 768) {
               class88.field1365[var1] = PacketBuffer.method3425(class13.field276[var1], class46.field590[var1], 1024 - class93.field1431);
            } else if(class93.field1431 > 256) {
               class88.field1365[var1] = class46.field590[var1];
            } else {
               class88.field1365[var1] = PacketBuffer.method3425(class46.field590[var1], class13.field276[var1], 256 - class93.field1431);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class88.field1365[var1] = class13.field276[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class93.field1424, 9, class93.field1424 + 128, var0 + 7);
      class93.field1419.method5098(class93.field1424, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = class93.field1424 + class19.field322.width * 9;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class93.field1425[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = ScriptEvent.field847[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class88.field1365[var7];
               var10 = class19.field322.pixels[var2];
               class19.field322.pixels[var2++] = (var8 * (var7 & '\uff00') + var9 * (var10 & '\uff00') & 16711680) + ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class19.field322.width - 128;
      }

      Rasterizer2D.setDrawRegion(class93.field1424 + 765 - 128, 9, class93.field1424 + 765, var0 + 7);
      class83.field1322.method5098(class93.field1424 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = class93.field1424 + 637 + 24 + class19.field322.width * 9;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class93.field1425[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = ScriptEvent.field847[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class88.field1365[var7];
               var10 = class19.field322.pixels[var2];
               class19.field322.pixels[var2++] = (var8 * (var7 & '\uff00') + var9 * (var10 & '\uff00') & 16711680) + ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class19.field322.width - var5 - var4;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "22"
   )
   public static void method1705() {
      class281.field3737 = new CombatInfoList();
   }
}
