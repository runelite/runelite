import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("nc")
   static class65 field1602;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2033589929
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1260067215
   )
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2041705125
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1428464173
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 638263727
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("a")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("m")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1844320329
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 763254085
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 569665639
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked = 0;
   @ObfuscatedName("k")
   static class144 field1614;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1129771161
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("rk")
   protected static String field1616;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass159;ILPlayer;II)V",
      garbageValue = "-1292462393"
   )
   static final void method2017(class159 var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 16) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.method2897(var6, 0, var5);
         class45.field911[var1] = var7;
         var2.method228(var7);
      }

      int var16;
      if((var3 & 8) != 0) {
         var5 = var0.readUnsignedShort();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var16 = var0.readUnsignedByte();
         class37.method816(var2, var5, var16);
      }

      if((var3 & 4) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 32) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            class88.sendGameMessage(2, var2.name, var2.overhead);
         } else if(var2 == WidgetNode.localPlayer) {
            class88.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field613 = false;
         var2.field620 = 0;
         var2.field641 = 0;
         var2.field637 = 150;
      }

      int var8;
      int var9;
      int var12;
      if((var3 & 64) != 0) {
         var5 = var0.readUnsignedByte();
         int var10;
         int var17;
         int var18;
         if(var5 > 0) {
            for(var16 = 0; var16 < var5; ++var16) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var17 = var0.method3039();
               if(var17 == 32767) {
                  var17 = var0.method3039();
                  var9 = var0.method3039();
                  var8 = var0.method3039();
                  var10 = var0.method3039();
               } else if(var17 != 32766) {
                  var9 = var0.method3039();
               } else {
                  var17 = -1;
               }

               var18 = var0.method3039();
               var2.method624(var17, var9, var8, var10, Client.gameCycle, var18);
            }
         }

         var16 = var0.readUnsignedByte();
         if(var16 > 0) {
            for(var17 = 0; var17 < var16; ++var17) {
               var8 = var0.method3039();
               var9 = var0.method3039();
               if(var9 != 32767) {
                  var10 = var0.method3039();
                  var18 = var0.readUnsignedByte();
                  var12 = var9 > 0?var0.readUnsignedByte():var18;
                  var2.method622(var8, Client.gameCycle, var9, var10, var18, var12);
               } else {
                  var2.method626(var8);
               }
            }
         }
      }

      if((var3 & 2) != 0) {
         var2.field631 = var0.readUnsignedShort();
         if(var2.field657 == 0) {
            var2.field654 = var2.field631;
            var2.field631 = -1;
         }
      }

      if((var3 & 1) != 0) {
         var5 = var0.readUnsignedShort();
         class177 var19 = (class177)Ignore.method207(class0.method12(), var0.readUnsignedByte());
         boolean var22 = var0.readUnsignedByte() == 1;
         var8 = var0.readUnsignedByte();
         var9 = var0.offset;
         if(var2.name != null && null != var2.composition) {
            boolean var21 = false;
            if(var19.field2670 && Friend.method189(var2.name)) {
               var21 = true;
            }

            if(!var21 && Client.field408 == 0 && !var2.field260) {
               class45.field918.offset = 0;
               var0.method2897(class45.field918.payload, 0, var8);
               class45.field918.offset = 0;
               String var11 = FontTypeFace.method3949(Varbit.method3615(ChatMessages.method955(class45.field918)));
               var2.overhead = var11.trim();
               var2.field620 = var5 >> 8;
               var2.field641 = var5 & 255;
               var2.field637 = 150;
               var2.field613 = var22;
               var2.inSequence = WidgetNode.localPlayer != var2 && var19.field2670 && "" != Client.field509 && var11.toLowerCase().indexOf(Client.field509) == -1;
               if(var19.field2669) {
                  var12 = var22?91:1;
               } else {
                  var12 = var22?90:2;
               }

               if(var19.field2665 != -1) {
                  int var15 = var19.field2665;
                  String var14 = "<img=" + var15 + ">";
                  class88.sendGameMessage(var12, var14 + var2.name, var11);
               } else {
                  class88.sendGameMessage(var12, var2.name, var11);
               }
            }
         }

         var0.offset = var8 + var9;
      }

      if((var3 & 2048) != 0) {
         var2.graphic = var0.readUnsignedShort();
         var5 = var0.readInt();
         var2.field616 = var5 >> 16;
         var2.field643 = (var5 & '\uffff') + Client.gameCycle;
         var2.field648 = 0;
         var2.field642 = 0;
         if(var2.field643 > Client.gameCycle) {
            var2.field648 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 512) != 0) {
         var2.field645 = var0.readByte();
         var2.field647 = var0.readByte();
         var2.field646 = var0.readByte();
         var2.field606 = var0.readByte();
         var2.field644 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field650 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field626 = var0.readUnsignedShort();
         if(var2.field242) {
            var2.field645 += var2.field265;
            var2.field647 += var2.field244;
            var2.field646 += var2.field265;
            var2.field606 += var2.field244;
            var2.field657 = 0;
         } else {
            var2.field645 += var2.pathX[0];
            var2.field647 += var2.pathY[0];
            var2.field646 += var2.pathX[0];
            var2.field606 += var2.pathY[0];
            var2.field657 = 1;
         }

         var2.field662 = 0;
      }

      if((var3 & 256) != 0) {
         class45.field928[var1] = var0.readByte();
      }

      if((var3 & 1024) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 4096) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if(var2.field242) {
         if(var4 == 127) {
            var2.method233(var2.field265, var2.field244);
         } else {
            byte var20;
            if(var4 != -1) {
               var20 = var4;
            } else {
               var20 = class45.field928[var1];
            }

            var2.method231(var2.field265, var2.field244, var20);
         }
      }

   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-954235972"
   )
   static final boolean method2018(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field342 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field412.method3266(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field412.method3263(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field412.method3237(false);
         }

         if(var1 == 325) {
            Client.field412.method3237(true);
         }

         if(var1 == 326) {
            Client.field332.method3144(54);
            Client.field412.method3235(Client.field332);
            return true;
         } else {
            return false;
         }
      }
   }
}
