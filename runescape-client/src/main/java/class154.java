import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class154 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1157180527
   )
   static int field2102 = 0;
   @ObfuscatedName("j")
   static byte[][] field2104 = new byte[250][];
   @ObfuscatedName("p")
   static byte[][] field2105 = new byte[1000][];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 953292817
   )
   static int field2106 = 0;
   @ObfuscatedName("n")
   static byte[][] field2107 = new byte[50][];
   @ObfuscatedName("u")
   static int[] field2108;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1205929065
   )
   static int field2110 = 0;

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "325299061"
   )
   static void method3034(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class99.method1995(var0, var1.id, var3, var4, var2);
      if(null != var1.children) {
         class99.method1995(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method2399((long)var1.id);
      if(var5 != null) {
         Player.method246(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "23"
   )
   static synchronized byte[] method3035(int var0) {
      byte[] var1;
      if(var0 == 100 && field2110 > 0) {
         var1 = field2105[--field2110];
         field2105[field2110] = null;
         return var1;
      } else if(var0 == 5000 && field2106 > 0) {
         var1 = field2104[--field2106];
         field2104[field2106] = null;
         return var1;
      } else if(var0 == 30000 && field2102 > 0) {
         var1 = field2107[--field2102];
         field2107[field2102] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass159;ILPlayer;II)V",
      garbageValue = "-745691607"
   )
   static final void method3036(class159 var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 4) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.method3010(var6, 0, var5);
         class45.field920[var1] = var7;
         var2.method226(var7);
      }

      int var16;
      if((var3 & 128) != 0) {
         var5 = var0.readUnsignedShort();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var16 = var0.readUnsignedByte();
         class47.method965(var2, var5, var16);
      }

      if((var3 & 32) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 8) != 0) {
         var2.overhead = var0.method2868();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            class16.method186(2, var2.name, var2.overhead);
         } else if(class36.localPlayer == var2) {
            class16.method186(2, var2.name, var2.overhead);
         }

         var2.field626 = false;
         var2.field640 = 0;
         var2.field641 = 0;
         var2.field638 = 150;
      }

      int var8;
      int var9;
      int var12;
      if((var3 & 64) != 0) {
         var5 = var0.readUnsignedByte();
         int var10;
         int var11;
         int var17;
         if(var5 > 0) {
            for(var16 = 0; var16 < var5; ++var16) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var17 = var0.method2846();
               if(var17 == 32767) {
                  var17 = var0.method2846();
                  var9 = var0.method2846();
                  var8 = var0.method2846();
                  var10 = var0.method2846();
               } else if(var17 != 32766) {
                  var9 = var0.method2846();
               } else {
                  var17 = -1;
               }

               var11 = var0.method2846();
               var2.method616(var17, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var16 = var0.readUnsignedByte();
         if(var16 > 0) {
            for(var17 = 0; var17 < var16; ++var17) {
               var8 = var0.method2846();
               var9 = var0.method2846();
               if(var9 != 32767) {
                  var10 = var0.method2846();
                  var11 = var0.readUnsignedByte();
                  var12 = var9 > 0?var0.readUnsignedByte():var11;
                  var2.method631(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method621(var8);
               }
            }
         }
      }

      if((var3 & 2) != 0) {
         var2.field651 = var0.readUnsignedShort();
         if(var2.field673 == 0) {
            var2.field674 = var2.field651;
            var2.field651 = -1;
         }
      }

      if((var3 & 1) != 0) {
         var5 = var0.readUnsignedShort();
         class177 var19 = (class177)class119.method2341(class15.method179(), var0.readUnsignedByte());
         boolean var22 = var0.readUnsignedByte() == 1;
         var8 = var0.readUnsignedByte();
         var9 = var0.offset;
         if(null != var2.name && var2.composition != null) {
            boolean var21 = false;
            if(var19.field2671 && Ignore.method206(var2.name)) {
               var21 = true;
            }

            if(!var21 && Client.field424 == 0 && !var2.field276) {
               class45.field919.offset = 0;
               var0.method3010(class45.field919.payload, 0, var8);
               class45.field919.offset = 0;
               String var18 = FontTypeFace.method3958(class32.method775(ItemLayer.method1511(class45.field919)));
               var2.overhead = var18.trim();
               var2.field640 = var5 >> 8;
               var2.field641 = var5 & 255;
               var2.field638 = 150;
               var2.field626 = var22;
               var2.inSequence = class36.localPlayer != var2 && var19.field2671 && "" != Client.field525 && var18.toLowerCase().indexOf(Client.field525) == -1;
               if(var19.field2670) {
                  var12 = var22?91:1;
               } else {
                  var12 = var22?90:2;
               }

               if(var19.field2669 != -1) {
                  int var15 = var19.field2669;
                  String var14 = "<img=" + var15 + ">";
                  class16.method186(var12, var14 + var2.name, var18);
               } else {
                  class16.method186(var12, var2.name, var18);
               }
            }
         }

         var0.offset = var8 + var9;
      }

      if((var3 & 4096) != 0) {
         var2.graphic = var0.readUnsignedShort();
         var5 = var0.method2965();
         var2.field664 = var5 >> 16;
         var2.field639 = (var5 & '\uffff') + Client.gameCycle;
         var2.field661 = 0;
         var2.field662 = 0;
         if(var2.field639 > Client.gameCycle) {
            var2.field661 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 256) != 0) {
         var2.field665 = var0.readByte();
         var2.field667 = var0.readByte();
         var2.field666 = var0.readByte();
         var2.field668 = var0.readByte();
         var2.field669 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field670 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field671 = var0.readUnsignedShort();
         if(var2.field261) {
            var2.field665 += var2.field280;
            var2.field667 += var2.field278;
            var2.field666 += var2.field280;
            var2.field668 += var2.field278;
            var2.field673 = 0;
         } else {
            var2.field665 += var2.pathX[0];
            var2.field667 += var2.pathY[0];
            var2.field666 += var2.pathX[0];
            var2.field668 += var2.pathY[0];
            var2.field673 = 1;
         }

         var2.field682 = 0;
      }

      if((var3 & 1024) != 0) {
         class45.field923[var1] = var0.readByte();
      }

      if((var3 & 2048) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 512) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.method2868();
         }
      }

      if(var2.field261) {
         if(var4 == 127) {
            var2.method230(var2.field280, var2.field278);
         } else {
            byte var20;
            if(var4 != -1) {
               var20 = var4;
            } else {
               var20 = class45.field923[var1];
            }

            var2.method248(var2.field280, var2.field278, var20);
         }
      }

   }

   class154() throws Throwable {
      throw new Error();
   }
}
