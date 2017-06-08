import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class47 {
   @ObfuscatedName("p")
   public Coordinates field596;
   @ObfuscatedName("i")
   public Coordinates field597;
   @ObfuscatedName("bh")
   static String field598;
   @ObfuscatedName("ai")
   static SpritePixels[] field599;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 905198255
   )
   public int field600;
   @ObfuscatedName("ac")
   public static BufferProvider field601;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "410301553"
   )
   static final void method686(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class1.field12.length; ++var2) {
         class1.field12[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class1.field12[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               RSSocket.field2286[var5] = (class1.field12[var5 - 1] + class1.field12[var5 + 1] + class1.field12[var5 - 128] + class1.field12[var5 + 128]) / 4;
            }
         }

         int[] var8 = class1.field12;
         class1.field12 = RSSocket.field2286;
         RSSocket.field2286 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var0.offsetX + var4 + 16;
                  int var6 = var3 + 16 + var0.offsetY;
                  int var7 = var5 + (var6 << 7);
                  class1.field12[var7] = 0;
               }
            }
         }
      }

   }

   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field600 = var1;
      this.field596 = var2;
      this.field597 = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "13"
   )
   static boolean method687(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field669.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var3 = class52.method754(class56.field667, var2, new Object[]{(new URL(class56.field667.getCodeBase(), var0)).toString()});
            return var3 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field667.getAppletContext().showDocument(new URL(class56.field667.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class52.method758(class56.field667, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class56.field667.getAppletContext().showDocument(new URL(class56.field667.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1438216001"
   )
   static int method688(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method1848();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "772427550"
   )
   static int method689(int var0, Script var1, boolean var2) {
      Widget var3 = class177.method3390(class83.intStack[--class165.intStackSize]);
      if(var0 == 2500) {
         class83.intStack[++class165.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class83.intStack[++class165.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class83.intStack[++class165.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class83.intStack[++class165.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class83.intStack[++class165.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class83.intStack[++class165.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZS)V",
      garbageValue = "256"
   )
   static void method690(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var1 == var6.parentId) {
            class1.method3(var6, var2, var3, var4);
            WidgetNode.method1068(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class21.method174(var0, var6, var4);
            }
         }
      }

   }
}
