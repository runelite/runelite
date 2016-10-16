import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class9 {
   @ObfuscatedName("p")
   static final BigInteger field139 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("g")
   static final BigInteger field140 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = 713437745
   )
   static int field142;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = -108740549
   )
   static int field148;
   @ObfuscatedName("da")
   @Export("mapRegions")
   static int[] mapRegions;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Lclass51;",
      garbageValue = "0"
   )
   public static class51 method119(int var0) {
      class51 var1 = (class51)class51.field1076.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class51.field1101.method3272(32, var0);
         var1 = new class51();
         if(null != var2) {
            var1.method1003(new Buffer(var2));
         }

         class51.field1076.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(IIS)Ljava/lang/String;",
      garbageValue = "8839"
   )
   static final String method120(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class188.method3706(16711680):(var2 < -6?class188.method3706(16723968):(var2 < -3?class188.method3706(16740352):(var2 < 0?class188.method3706(16756736):(var2 > 9?class188.method3706('\uff00'):(var2 > 6?class188.method3706(4259584):(var2 > 3?class188.method3706(8453888):(var2 > 0?class188.method3706(12648192):class188.method3706(16776960))))))));
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-623033811"
   )
   static void method121() {
      int var0 = GameEngine.field2239;
      int var1 = GameEngine.field2240;
      int var2 = class177.field2942 - class50.field1069 - var0;
      int var3 = class137.field2111 - class139.field2143 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field389.method3063();
            int var5 = 0;
            int var6 = 0;
            if(var4 == class118.field2008) {
               Insets var7 = class118.field2008.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class137.field2111);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class177.field2942, var1);
            }

            if(var2 > 0) {
               var9.fillRect(class177.field2942 + var5 - var2, var6, var2, class137.field2111);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class137.field2111 + var6 - var3, class177.field2942, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2120227288"
   )
   static final void method122() {
      int[] var0 = class34.field739;

      int var1;
      for(var1 = 0; var1 < class34.field743; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(null != var2 && var2.field817 > 0) {
            --var2.field817;
            if(var2.field817 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field309; ++var1) {
         int var4 = Client.field307[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(null != var3 && var3.field817 > 0) {
            --var3.field817;
            if(var3.field817 == 0) {
               var3.overhead = null;
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-79"
   )
   static void method123(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method3775((long)var0);
      if(null != var1) {
         var1.unlink();
      }
   }
}
