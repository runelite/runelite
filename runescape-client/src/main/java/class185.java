import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class185 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -349388265
   )
   static int field2746 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 133497707
   )
   public static int field2747 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -275350249958080207L
   )
   static long field2748;
   @ObfuscatedName("v")
   static XHashTable field2749 = new XHashTable(4096);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1579762079
   )
   static int field2750 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -864717679
   )
   static int field2751 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2120747365
   )
   static int field2752 = 0;
   @ObfuscatedName("a")
   static XHashTable field2754 = new XHashTable(4096);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1999959331
   )
   static int field2755 = 0;
   @ObfuscatedName("m")
   static Node2LinkedList field2756 = new Node2LinkedList();
   @ObfuscatedName("x")
   public static class110 field2757;
   @ObfuscatedName("q")
   static Buffer field2758 = new Buffer(8);
   @ObfuscatedName("s")
   static XHashTable field2759 = new XHashTable(4096);
   @ObfuscatedName("u")
   static class184[] field2760 = new class184[256];
   @ObfuscatedName("l")
   static CRC32 field2761 = new CRC32();
   @ObfuscatedName("r")
   static Buffer field2762;
   @ObfuscatedName("e")
   static byte field2763 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 851875199
   )
   static int field2764 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 186250803
   )
   public static int field2765 = 0;
   @ObfuscatedName("p")
   static XHashTable field2766 = new XHashTable(32);
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = 87211559
   )
   static int field2767;
   @ObfuscatedName("z")
   static int[] field2768;

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1754738323"
   )
   static final void method3482(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         ObjectComposition.field2944.field690 = !ObjectComposition.field2944.field690;
         class146.method2811();
         if(ObjectComposition.field2944.field690) {
            class88.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            class88.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.field302 = !Client.field302;
      }

      if(Client.field425 >= 2) {
         if(var0.equalsIgnoreCase("fpson")) {
            Client.field302 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.field302 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            GameObject.method2021();
         }

         if(var0.equalsIgnoreCase("errortest") && Client.field309 == 2) {
            throw new RuntimeException();
         }
      }

      Client.field332.method3144(13);
      Client.field332.method2873(var0.length() + 1);
      Client.field332.method2915(var0);
   }

   class185() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)LMessageNode;",
      garbageValue = "2"
   )
   static MessageNode method3490(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      return var2.method983(var1);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "256"
   )
   static final void method3491() {
      if(Client.widgetRoot != -1) {
         Tile.method1642(Client.widgetRoot);
      }

      int var0;
      for(var0 = 0; var0 < Client.field468; ++var0) {
         if(Client.field494[var0]) {
            Client.field495[var0] = true;
         }

         Client.field435[var0] = Client.field494[var0];
         Client.field494[var0] = false;
      }

      Client.field493 = Client.gameCycle;
      Client.field438 = -1;
      Client.field465 = -1;
      class22.field237 = null;
      if(Client.widgetRoot != -1) {
         Client.field468 = 0;
         class1.method18(Client.widgetRoot, 0, 0, RSCanvas.field1756, class65.field1128, 0, 0, -1);
      }

      Rasterizer2D.method4018();
      if(!Client.isMenuOpen) {
         if(Client.field438 != -1) {
            class196.method3631(Client.field438, Client.field465);
         }
      } else {
         WallObject.method1981();
      }

      if(Client.field501 == 3) {
         for(var0 = 0; var0 < Client.field468; ++var0) {
            if(Client.field435[var0]) {
               Rasterizer2D.method4034(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711935, 128);
            } else if(Client.field495[var0]) {
               Rasterizer2D.method4034(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711680, 128);
            }
         }
      }

      var0 = CollisionData.plane;
      int var1 = WidgetNode.localPlayer.x;
      int var2 = WidgetNode.localPlayer.y;
      int var3 = Client.field365;

      for(class31 var4 = (class31)class31.field703.method2503(); var4 != null; var4 = (class31)class31.field703.method2492()) {
         if(var4.field708 != -1 || var4.field714 != null) {
            int var5 = 0;
            if(var1 > var4.field705) {
               var5 += var1 - var4.field705;
            } else if(var1 < var4.field704) {
               var5 += var4.field704 - var1;
            }

            if(var2 > var4.field706) {
               var5 += var2 - var4.field706;
            } else if(var2 < var4.field716) {
               var5 += var4.field716 - var2;
            }

            if(var5 - 64 <= var4.field712 && Client.field397 != 0 && var0 == var4.field702) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field712 - var5) * Client.field397 / var4.field712;
               Object var10000;
               if(var4.field709 == null) {
                  if(var4.field708 >= 0) {
                     var10000 = null;
                     class53 var7 = class53.method1064(class150.field2041, var4.field708, 0);
                     if(null != var7) {
                        class55 var8 = var7.method1058().method1097(DecorativeObject.field1602);
                        class66 var9 = class66.method1256(var8, 100, var6);
                        var9.method1259(-1);
                        Client.field572.method1024(var9);
                        var4.field709 = var9;
                     }
                  }
               } else {
                  var4.field709.method1260(var6);
               }

               if(var4.field701 == null) {
                  if(var4.field714 != null && (var4.field713 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field714.length);
                     var10000 = null;
                     class53 var12 = class53.method1064(class150.field2041, var4.field714[var11], 0);
                     if(null != var12) {
                        class55 var13 = var12.method1058().method1097(DecorativeObject.field1602);
                        class66 var10 = class66.method1256(var13, 100, var6);
                        var10.method1259(0);
                        Client.field572.method1024(var10);
                        var4.field701 = var10;
                        var4.field713 = var4.field710 + (int)(Math.random() * (double)(var4.field711 - var4.field710));
                     }
                  }
               } else {
                  var4.field701.method1260(var6);
                  if(!var4.field701.linked()) {
                     var4.field701 = null;
                  }
               }
            } else {
               if(null != var4.field709) {
                  Client.field572.method1000(var4.field709);
                  var4.field709 = null;
               }

               if(null != var4.field701) {
                  Client.field572.method1000(var4.field701);
                  var4.field701 = null;
               }
            }
         }
      }

      Client.field365 = 0;
   }
}
