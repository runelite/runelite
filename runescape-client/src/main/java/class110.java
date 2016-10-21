import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public abstract class class110 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2054393733
   )
   public int field1934;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1147301085
   )
   public int field1935;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 355382981
   )
   public int field1936;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2099822045
   )
   public int field1938;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-790374412"
   )
   protected abstract boolean vmethod2401(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "-1815378855"
   )
   static void method2402(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = Player.method44(var1, var2);
      if(var5 != null) {
         if(var5.field2888 != null) {
            class0 var6 = new class0();
            var6.field2 = var5;
            var6.field0 = var0;
            var6.field9 = var4;
            var6.field1 = var5.field2888;
            class112.method2452(var6);
         }

         boolean var10 = true;
         if(var5.contentType > 0) {
            var10 = class5.method80(var5);
         }

         if(var10) {
            int var8 = class93.method2130(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> 1 + var9 & 1) != 0;
            if(var7) {
               if(var0 == 1) {
                  Client.field397.method2768(176);
                  Client.field397.method2521(var1);
                  Client.field397.method2519(var2);
                  Client.field397.method2519(var3);
               }

               if(var0 == 2) {
                  Client.field397.method2768(209);
                  Client.field397.method2521(var1);
                  Client.field397.method2519(var2);
                  Client.field397.method2519(var3);
               }

               if(var0 == 3) {
                  Client.field397.method2768(84);
                  Client.field397.method2521(var1);
                  Client.field397.method2519(var2);
                  Client.field397.method2519(var3);
               }

               if(var0 == 4) {
                  Client.field397.method2768(103);
                  Client.field397.method2521(var1);
                  Client.field397.method2519(var2);
                  Client.field397.method2519(var3);
               }

               if(var0 == 5) {
                  Client.field397.method2768(242);
                  Client.field397.method2521(var1);
                  Client.field397.method2519(var2);
                  Client.field397.method2519(var3);
               }

               if(var0 == 6) {
                  Client.field397.method2768(216);
                  Client.field397.method2521(var1);
                  Client.field397.method2519(var2);
                  Client.field397.method2519(var3);
               }

               if(var0 == 7) {
                  Client.field397.method2768(120);
                  Client.field397.method2521(var1);
                  Client.field397.method2519(var2);
                  Client.field397.method2519(var3);
               }

               if(var0 == 8) {
                  Client.field397.method2768(246);
                  Client.field397.method2521(var1);
                  Client.field397.method2519(var2);
                  Client.field397.method2519(var3);
               }

               if(var0 == 9) {
                  Client.field397.method2768(34);
                  Client.field397.method2521(var1);
                  Client.field397.method2519(var2);
                  Client.field397.method2519(var3);
               }

               if(var0 == 10) {
                  Client.field397.method2768(108);
                  Client.field397.method2521(var1);
                  Client.field397.method2519(var2);
                  Client.field397.method2519(var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "-2001267312"
   )
   public static void method2404(String var0, boolean var1, boolean var2) {
      if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
         try {
            Desktop.getDesktop().browse(new URI(var0));
            return;
         } catch (Exception var4) {
            ;
         }
      }

      if(class141.field2180.startsWith("win")) {
         class20.method565(var0, 0);
      } else if(class141.field2180.startsWith("mac")) {
         SecondaryBufferProvider.method1668(var0, 1, "openjs");
      } else {
         class20.method565(var0, 2);
      }

   }

   @ObfuscatedName("f")
   public static final void method2407(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            class9.method115(var0 - 1L);
            class9.method115(1L);
         } else {
            class9.method115(var0);
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2099903726"
   )
   public static void method2408(int var0) {
      if(class186.field3005 != 0) {
         class186.field2999 = var0;
      } else {
         class28.field670.method3697(var0);
      }

   }
}
