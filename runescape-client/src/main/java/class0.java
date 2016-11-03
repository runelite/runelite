import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("k")
public class class0 extends Node {
   @ObfuscatedName("k")
   Object[] field0;
   @ObfuscatedName("q")
   boolean field1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -344686771
   )
   int field2;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1171715109
   )
   int field3;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 147099069
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1729906201
   )
   int field5;
   @ObfuscatedName("m")
   Widget field6;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -581215089
   )
   int field7;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1790522697
   )
   int field8;
   @ObfuscatedName("h")
   String field9;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1697467015
   )
   int field10;
   @ObfuscatedName("f")
   Widget field11;
   @ObfuscatedName("ee")
   static SpritePixels[] field12;

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-27074"
   )
   static void method0() {
      Client var0 = Client.field480;
      synchronized(Client.field480) {
         Container var1 = Client.field480.method3061();
         if(null != var1) {
            class13.field198 = Math.max(var1.getSize().width, MessageNode.field806);
            class11.field169 = Math.max(var1.getSize().height, class159.field2344);
            if(var1 == class12.field188) {
               Insets var2 = class12.field188.getInsets();
               class13.field198 -= var2.left + var2.right;
               class11.field169 -= var2.bottom + var2.top;
            }

            if(class13.field198 <= 0) {
               class13.field198 = 1;
            }

            if(class11.field169 <= 0) {
               class11.field169 = 1;
            }

            int var9 = Client.isResized?2:1;
            if(var9 == 1) {
               GroundObject.field1652 = Client.field495;
               VertexNormal.field1689 = Client.field339 * 503;
            } else {
               GroundObject.field1652 = Math.min(class13.field198, 7680);
               VertexNormal.field1689 = Math.min(class11.field169, 2160);
            }

            GameEngine.field2251 = (class13.field198 - GroundObject.field1652) / 2;
            GameEngine.field2242 = 0;
            VertexNormal.canvas.setSize(GroundObject.field1652, VertexNormal.field1689);
            Sequence.bufferProvider = class18.method183(GroundObject.field1652, VertexNormal.field1689, VertexNormal.canvas);
            if(class12.field188 == var1) {
               Insets var3 = class12.field188.getInsets();
               VertexNormal.canvas.setLocation(var3.left + GameEngine.field2251, var3.top + GameEngine.field2242);
            } else {
               VertexNormal.canvas.setLocation(GameEngine.field2251, GameEngine.field2242);
            }

            int var10 = GroundObject.field1652;
            int var4 = VertexNormal.field1689;
            if(class13.field198 < var10) {
               var10 = class13.field198;
            }

            if(class11.field169 < var4) {
               var4 = class11.field169;
            }

            if(null != class130.field2102) {
               try {
                  Client var5 = Client.field480;
                  int var6 = Client.isResized?2:1;
                  Object[] var7 = new Object[]{Integer.valueOf(var6)};
                  JSObject.getWindow(var5).call("resize", var7);
               } catch (Throwable var11) {
                  ;
               }
            }

            if(Client.widgetRoot != -1) {
               ObjectComposition.method874(Client.widgetRoot, GroundObject.field1652, VertexNormal.field1689, true);
            }

            class167.method3258();
         }
      }
   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Z",
      garbageValue = "-5"
   )
   static boolean method1(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = class112.method2486(var0, class43.field996);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class112.method2486(Client.friends[var3].name, class43.field996)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class112.method2486(class165.localPlayer.name, class43.field996))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-334192876"
   )
   public static final boolean method2() {
      class140 var0 = class140.keyboard;
      synchronized(class140.keyboard) {
         if(class140.field2167 == class140.field2173) {
            return false;
         } else {
            class13.field197 = class140.field2168[class140.field2173];
            ItemLayer.field1744 = class140.field2165[class140.field2173];
            class140.field2173 = class140.field2173 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1388326486"
   )
   public static void method3(int var0) {
      if(var0 != -1) {
         if(Widget.validInterfaces[var0]) {
            class214.field3185.method3292(var0);
            if(Widget.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(null != Widget.widgets[var0][var2]) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }
   }
}
