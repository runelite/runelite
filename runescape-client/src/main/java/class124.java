import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class124 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1025032505
   )
   static int field2078 = 0;
   @ObfuscatedName("r")
   static byte[][] field2079 = new byte[1000][];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -345884609
   )
   static int field2080 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1555060709
   )
   static int field2081 = 0;
   @ObfuscatedName("b")
   public static String[] field2082;
   @ObfuscatedName("t")
   static byte[][] field2083 = new byte[50][];
   @ObfuscatedName("z")
   static byte[][] field2084 = new byte[250][];

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "27430"
   )
   static String method2776() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class11.field166.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "1891608639"
   )
   static final void method2777(Widget var0, int var1, int var2) {
      if(Client.field453 == null && !Client.isMenuOpen) {
         if(null != var0) {
            Widget var5 = var0;
            int var7 = GameEngine.method3133(var0);
            int var6 = var7 >> 17 & 7;
            int var8 = var6;
            Widget var4;
            int var9;
            if(var6 == 0) {
               var4 = null;
            } else {
               var9 = 0;

               while(true) {
                  if(var9 >= var8) {
                     var4 = var5;
                     break;
                  }

                  var5 = class24.method600(var5.parentId);
                  if(var5 == null) {
                     var4 = null;
                     break;
                  }

                  ++var9;
               }
            }

            Widget var10 = var4;
            if(var4 == null) {
               var10 = var0.parent;
            }

            if(null != var10) {
               Client.field453 = var0;
               var5 = var0;
               var7 = GameEngine.method3133(var0);
               var6 = var7 >> 17 & 7;
               var8 = var6;
               if(var6 == 0) {
                  var4 = null;
               } else {
                  var9 = 0;

                  while(true) {
                     if(var9 >= var8) {
                        var4 = var5;
                        break;
                     }

                     var5 = class24.method600(var5.parentId);
                     if(var5 == null) {
                        var4 = null;
                        break;
                     }

                     ++var9;
                  }
               }

               var10 = var4;
               if(var4 == null) {
                  var10 = var0.parent;
               }

               Client.field443 = var10;
               Client.field511 = var1;
               Client.field456 = var2;
               Client.field563 = 0;
               Client.field464 = false;
               if(Client.menuOptionCount > 0) {
                  class85.method1925(Client.menuOptionCount - 1);
               }

               return;
            }
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IS)[B",
      garbageValue = "2202"
   )
   static synchronized byte[] method2778(int var0) {
      byte[] var1;
      if(var0 == 100 && field2081 > 0) {
         var1 = field2079[--field2081];
         field2079[field2081] = null;
         return var1;
      } else if(var0 == 5000 && field2078 > 0) {
         var1 = field2084[--field2078];
         field2084[field2078] = null;
         return var1;
      } else if(var0 == 30000 && field2080 > 0) {
         var1 = field2083[--field2080];
         field2083[field2080] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass171;II)V",
      garbageValue = "-687255232"
   )
   static void method2779(class171 var0, int var1) {
      if(class174.field2795 != null) {
         class174.field2795.offset = var1 * 8 + 5;
         int var2 = class174.field2795.method2533();
         int var3 = class174.field2795.method2533();
         var0.method3397(var2, var3);
      } else {
         class34.method745((class171)null, 255, 255, 0, (byte)0, true);
         class174.field2796[var1] = var0;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1632325373"
   )
   static void method2780(int var0, int var1) {
      if(Client.field517 != 0 && var0 != -1) {
         class50.method1046(class85.field1506, var0, 0, Client.field517, false);
         Client.field426 = true;
      }

   }
}
