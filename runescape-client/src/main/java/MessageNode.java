import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1327739857
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 563126073
   )
   @Export("type")
   int type;
   @ObfuscatedName("y")
   @Export("name")
   String name;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1354997051
   )
   @Export("id")
   int id;
   @ObfuscatedName("g")
   @Export("value")
   String value;
   @ObfuscatedName("r")
   static int[] field776;
   @ObfuscatedName("p")
   @Export("sender")
   String sender;
   @ObfuscatedName("x")
   static int[] field780;
   @ObfuscatedName("c")
   public static Buffer field781;

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "([LWidget;IB)V",
      garbageValue = "-52"
   )
   static final void method748(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3 && var1 == var3.parentId && (!var3.field2797 || !class13.method164(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.field2797 && class13.method164(var3) && var3 != ItemComposition.field1196) {
                  continue;
               }

               method748(var0, var3.id);
               if(var3.children != null) {
                  method748(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.method3775((long)var3.id);
               if(null != var7) {
                  var5 = var7.id;
                  if(class174.method3393(var5)) {
                     method748(Widget.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2845 != -1 || var3.field2870 != -1) {
                  boolean var4 = Player.method37(var3);
                  if(var4) {
                     var5 = var3.field2870;
                  } else {
                     var5 = var3.field2845;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class4.getAnimation(var5);

                     for(var3.field2921 += Client.field297; var3.field2921 > var6.field981[var3.field2811]; class32.method685(var3)) {
                        var3.field2921 -= var6.field981[var3.field2811];
                        ++var3.field2811;
                        if(var3.field2811 >= var6.field969.length) {
                           var3.field2811 -= var6.field973;
                           if(var3.field2811 < 0 || var3.field2811 >= var6.field969.length) {
                              var3.field2811 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2859 != 0 && !var3.field2797) {
                  int var8 = var3.field2859 >> 16;
                  var5 = var3.field2859 << 16 >> 16;
                  var8 *= Client.field297;
                  var5 *= Client.field297;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var3.rotationZ + var5 & 2047;
                  class32.method685(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "49"
   )
   void method749(int var1, String var2, String var3, String var4) {
      int var5 = ++class11.field162 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(Lclass16;B)V",
      garbageValue = "18"
   )
   static final void method753(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field208 == 0) {
         var1 = class114.region.method2004(var0.field215, var0.field209, var0.field221);
      }

      if(var0.field208 == 1) {
         var1 = class114.region.method1942(var0.field215, var0.field209, var0.field221);
      }

      if(var0.field208 == 2) {
         var1 = class114.region.method1943(var0.field215, var0.field209, var0.field221);
      }

      if(var0.field208 == 3) {
         var1 = class114.region.method1944(var0.field215, var0.field209, var0.field221);
      }

      if(var1 != 0) {
         int var5 = class114.region.method1945(var0.field215, var0.field209, var0.field221, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field207 = var2;
      var0.field213 = var3;
      var0.field212 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass0;I)V",
      garbageValue = "1980335482"
   )
   static void method754(class0 var0) {
      Player.method35(var0, 200000);
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      int var5 = ++class11.field162 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "332776828"
   )
   static final String[] method755(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "61"
   )
   public static boolean method757(int var0, int var1) {
      return (var0 >> 1 + var1 & 1) != 0;
   }
}
