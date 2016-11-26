import java.awt.Component;
import java.io.IOException;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class36 {
   @ObfuscatedName("r")
   static final BigInteger field762 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("w")
   static final BigInteger field763 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -881500161
   )
   static int field770;
   @ObfuscatedName("az")
   static class102 field772;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "190409056"
   )
   static void method750() {
      Object var0 = class183.field2729;
      synchronized(class183.field2729) {
         if(class183.field2734 == 0) {
            class15.field159.method2000(new class183(), 5);
         }

         class183.field2734 = 600;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1877309214"
   )
   static final void method751() {
      for(class33 var0 = (class33)Client.field421.method2466(); var0 != null; var0 = (class33)Client.field421.method2461()) {
         if(class166.plane == var0.field733 && !var0.field740) {
            if(Client.gameCycle >= var0.field732) {
               var0.method707(Client.field517);
               if(var0.field740) {
                  var0.unlink();
               } else {
                  class157.region.method1751(var0.field733, var0.field734, var0.field731, var0.field736, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "25"
   )
   public static void method752(Buffer var0) {
      byte[] var1 = new byte[24];

      try {
         class104.field1689.method1425(0L);
         class104.field1689.method1408(var1);

         int var2;
         for(var2 = 0; var2 < 24 && var1[var2] == 0; ++var2) {
            ;
         }

         if(var2 >= 24) {
            throw new IOException();
         }
      } catch (Exception var5) {
         for(int var3 = 0; var3 < 24; ++var3) {
            var1[var3] = -1;
         }
      }

      var0.method2984(var1, 0, 24);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-96"
   )
   public static void method753() {
      try {
         class104.field1680.method1427();

         for(int var0 = 0; var0 < class216.field3158; ++var0) {
            class104.field1688[var0].method1427();
         }

         class104.field1687.method1427();
         class104.field1689.method1427();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-82"
   )
   static void method754(int var0) {
      if(var0 == -1 && !Client.field524) {
         class13.method186();
      } else if(var0 != -1 && var0 != Client.field318 && Client.field522 != 0 && !Client.field524) {
         class184 var1 = class34.field746;
         int var2 = Client.field522;
         class138.field1917 = 1;
         class1.field12 = var1;
         class138.field1918 = var0;
         Frames.field1566 = 0;
         class101.field1649 = var2;
         class34.field742 = false;
         class114.field1792 = 2;
      }

      Client.field318 = var0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/awt/Component;III)Lclass57;",
      garbageValue = "599185427"
   )
   public static final class57 method755(class103 var0, Component var1, int var2, int var3) {
      if(class57.field1031 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class59 var4 = new class59();
            var4.field1035 = new int[(class57.field1046?2:1) * 256];
            var4.field1040 = var3;
            var4.vmethod1115(var1);
            var4.field1039 = (var3 & -1024) + 1024;
            if(var4.field1039 > 16384) {
               var4.field1039 = 16384;
            }

            var4.vmethod1108(var4.field1039);
            if(class57.field1032 > 0 && class231.field3280 == null) {
               class231.field3280 = new class63();
               class231.field3280.field1081 = var0;
               var0.method2000(class231.field3280, class57.field1032);
            }

            if(null != class231.field3280) {
               if(null != class231.field3280.field1080[var2]) {
                  throw new IllegalArgumentException();
               }

               class231.field3280.field1080[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class57();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "-935132519"
   )
   static void method756(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class9.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field595 = 0;
            var0.actionAnimationDisable = var2;
            var0.field631 = 0;
         }

         if(var3 == 2) {
            var0.field631 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class9.getAnimation(var1).forcedPriority >= class9.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field595 = 0;
         var0.actionAnimationDisable = var2;
         var0.field631 = 0;
         var0.field654 = var0.field649;
      }

   }
}
