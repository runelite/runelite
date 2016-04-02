import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("World")
public class class25 {
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -489797325
   )
   static int field612;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 717018067
   )
   static int field613 = 0;
   @ObfuscatedName("p")
   @Export("worldList")
   static class25[] field615;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -909519517
   )
   static int field616 = 0;
   @ObfuscatedName("a")
   static int[] field618 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("r")
   static int[] field619 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1869166171
   )
   @Export("id")
   int field620;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1364859837
   )
   @Export("mask")
   int field621;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1848864653
   )
   @Export("playerCount")
   int field622;
   @ObfuscatedName("i")
   @Export("address")
   String field623;
   @ObfuscatedName("j")
   @Export("activity")
   String field624;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1002444595
   )
   @Export("location")
   int field625;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1739602373
   )
   @Export("index")
   int field627;
   @ObfuscatedName("cp")
   static class224 field628;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 2004154341
   )
   static int field629;

   @ObfuscatedName("m")
   boolean method598() {
      return (4 & this.field621) != 0;
   }

   @ObfuscatedName("n")
   boolean method599() {
      return (8 & this.field621) != 0;
   }

   @ObfuscatedName("y")
   boolean method600() {
      return 0 != (536870912 & this.field621);
   }

   @ObfuscatedName("i")
   boolean method604() {
      return 0 != (33554432 & this.field621);
   }

   @ObfuscatedName("k")
   boolean method613() {
      return (2 & this.field621) != 0;
   }

   @ObfuscatedName("dn")
   static final void method624(int var0) {
      if(class113.method2462(var0)) {
         class173[] var1 = class173.field2837[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class173 var3 = var1[var2];
            if(var3 != null) {
               var3.field2749 = 0;
               var3.field2868 = 0;
            }
         }

      }
   }

   @ObfuscatedName("r")
   boolean method628() {
      return (1 & this.field621) != 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-934736824"
   )
   static void method629(int var0, int var1, int var2, int var3) {
      class15 var4 = (class15)class15.field216.method3788((long)var0);
      if(null == var4) {
         var4 = new class15();
         class15.field216.method3789(var4, (long)var0);
      }

      if(var4.field219.length <= var1) {
         int[] var5 = new int[1 + var1];
         int[] var6 = new int[1 + var1];

         int var7;
         for(var7 = 0; var7 < var4.field219.length; ++var7) {
            var5[var7] = var4.field219[var7];
            var6[var7] = var4.field217[var7];
         }

         for(var7 = var4.field219.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.field219 = var5;
         var4.field217 = var6;
      }

      var4.field219[var1] = var2;
      var4.field217[var1] = var3;
   }

   @ObfuscatedName("w")
   public static int method630(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return 1 + var0;
   }

   @ObfuscatedName("dd")
   static String method631(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(client.field282 == 1) {
         var0 = var0 + "-wtrc";
      } else if(2 == client.field282) {
         var0 = var0 + "-wtqa";
      } else if(client.field282 == 3) {
         var0 = var0 + "-wtwip";
      } else if(5 == client.field282) {
         var0 = var0 + "-wti";
      } else if(client.field282 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != class0.field8) {
         var3 = "/p=" + class0.field8;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + client.field286 + "/a=" + class107.field1860 + var3 + "/";
   }
}
