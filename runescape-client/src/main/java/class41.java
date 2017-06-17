import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public final class class41 {
   @ObfuscatedName("m")
   boolean field558;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -131245631
   )
   int field559;
   @ObfuscatedName("e")
   class44 field560;
   @ObfuscatedName("t")
   SpritePixels field561;
   @ObfuscatedName("w")
   HashMap field563;
   @ObfuscatedName("j")
   HashMap field564;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1713164117
   )
   int field565;
   @ObfuscatedName("p")
   boolean field566;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 931868223
   )
   int field567;
   @ObfuscatedName("i")
   ModIcon[] field568;
   @ObfuscatedName("z")
   class34[][] field569;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 817481203
   )
   int field570;
   @ObfuscatedName("f")
   final HashMap field575;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;ZI)V",
      garbageValue = "1496036716"
   )
   public void method526(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field558) {
         this.field566 = false;
         this.field558 = true;
         System.nanoTime();
         int var4 = var1.method4055(class40.field556.field548);
         int var5 = var1.method4020(var4, var2);
         Buffer var6 = new Buffer(var1.method4014(class40.field556.field548, var2));
         Buffer var7 = new Buffer(var1.method4014(class40.field547.field548, var2));
         Buffer var8 = new Buffer(var1.method4014(var2, class40.field551.field548));
         System.nanoTime();
         System.nanoTime();
         this.field560 = new class44();

         try {
            this.field560.method604(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var17) {
            return;
         }

         this.field560.method297();
         this.field560.method298();
         this.field560.method286();
         this.field567 = this.field560.method293() * 64;
         this.field565 = this.field560.method305() * 64;
         this.field559 = (this.field560.method294() - this.field560.method293() + 1) * 64;
         this.field570 = (this.field560.method296() - this.field560.method305() + 1) * 64;
         int var9 = this.field560.method294() - this.field560.method293() + 1;
         int var10 = this.field560.method296() - this.field560.method305() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field569 = new class34[var9][var10];
         Iterator var11 = this.field560.field585.iterator();

         int var13;
         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            var13 = var12.field424;
            int var14 = var12.field420;
            int var15 = var13 - this.field560.method293();
            int var16 = var14 - this.field560.method305();
            this.field569[var15][var16] = new class34(var13, var14, this.field560.method291(), this.field575);
            this.field569[var15][var16].method436(var12, this.field560.field587);
         }

         for(int var18 = 0; var18 < var9; ++var18) {
            for(var13 = 0; var13 < var10; ++var13) {
               if(this.field569[var18][var13] == null) {
                  this.field569[var18][var13] = new class34(this.field560.method293() + var18, this.field560.method305() + var13, this.field560.method291(), this.field575);
                  this.field569[var18][var13].method377(this.field560.field586, this.field560.field587);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4013(class40.field557.field548, var2)) {
            byte[] var19 = var1.method4014(class40.field557.field548, var2);
            this.field561 = RSCanvas.method740(var19);
         }

         System.nanoTime();
         this.field566 = true;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1681923664"
   )
   public final void method527() {
      this.field563 = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1809931832"
   )
   public final void method528(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.method4884(var12);
      class29 var13 = this.method536(var1, var2, var3, var4);
      float var14 = this.method537(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field564.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method637();
         this.field564.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field434; var17 < var13.field435 + var13.field434; ++var17) {
         for(var18 = var13.field432; var18 < var13.field433 + var13.field432; ++var18) {
            this.method530(var17, var18, var22);
            this.field569[var17][var18].method359(var15, (class46)this.field564.get(Integer.valueOf(var15)), var22, this.field568);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.method4821(var12);
      var17 = (int)(64.0F * var14);
      var18 = this.field567 + var1;
      int var19 = this.field565 + var2;

      for(int var20 = var13.field434; var20 < var13.field435 + var13.field434; ++var20) {
         for(int var21 = var13.field432; var21 < var13.field433 + var13.field432; ++var21) {
            this.field569[var20][var21].method354(var5 + (this.field569[var20][var21].field483 * 64 - var18) * var17 / 64, var8 - var17 * (this.field569[var20][var21].field487 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZB)V",
      garbageValue = "81"
   )
   public final void method529(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method536(var1, var2, var3, var4);
      float var15 = this.method537(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field567 + var1;
      int var18 = var2 + this.field565;

      int var19;
      int var20;
      for(var19 = var14.field434; var19 < var14.field435 + var14.field434; ++var19) {
         for(var20 = var14.field432; var20 < var14.field433 + var14.field432; ++var20) {
            if(var13) {
               this.field569[var19][var20].method460();
            }

            this.field569[var19][var20].method360(var5 + (this.field569[var19][var20].field483 * 64 - var17) * var16 / 64, var8 - (this.field569[var19][var20].field487 * 64 - var18 + 64) * var16 / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field434; var19 < var14.field434 + var14.field435; ++var19) {
            for(var20 = var14.field432; var20 < var14.field433 + var14.field432; ++var20) {
               this.field569[var19][var20].method361(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[Lclass34;B)V",
      garbageValue = "-89"
   )
   void method530(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field569.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field569[0].length - 1;
      if(var7) {
         var3[class228.field3160.rsOrdinal()] = null;
      } else {
         var3[class228.field3160.rsOrdinal()] = this.field569[var1][var2 + 1];
      }

      var3[class228.field3156.rsOrdinal()] = !var7 && !var5?this.field569[var1 + 1][var2 + 1]:null;
      var3[class228.field3162.rsOrdinal()] = !var7 && !var4?this.field569[var1 - 1][var2 + 1]:null;
      var3[class228.field3157.rsOrdinal()] = var5?null:this.field569[var1 + 1][var2];
      var3[class228.field3161.rsOrdinal()] = var4?null:this.field569[var1 - 1][var2];
      var3[class228.field3165.rsOrdinal()] = var6?null:this.field569[var1][var2 - 1];
      var3[class228.field3155.rsOrdinal()] = !var6 && !var5?this.field569[var1 + 1][var2 - 1]:null;
      var3[class228.field3159.rsOrdinal()] = !var6 && !var4?this.field569[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "-1091096010"
   )
   public void method531(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field561 != null) {
         this.field561.method4963(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field563 == null) {
               this.method533();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var9;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var10 = ((Integer)var8.next()).intValue();
                  var9 = (List)this.field563.get(Integer.valueOf(var10));
               } while(var9 == null);

               Iterator var14 = var9.iterator();

               while(var14.hasNext()) {
                  class39 var11 = (class39)var14.next();
                  int var12 = var3 * (var11.field538.worldX - this.field567) / this.field559;
                  int var13 = var4 - var4 * (var11.field538.worldY - this.field565) / this.field570;
                  Rasterizer2D.method4824(var12 + var1, var2 + var13, 2, 16776960, 256);
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method533() {
      if(this.field563 == null) {
         this.field563 = new HashMap();
      }

      this.field563.clear();

      for(int var1 = 0; var1 < this.field569.length; ++var1) {
         for(int var2 = 0; var2 < this.field569[var1].length; ++var2) {
            List var3 = this.field569[var1][var2].method390();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field563.containsKey(Integer.valueOf(var5.field541))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field563.put(Integer.valueOf(var5.field541), var6);
               } else {
                  List var7 = (List)this.field563.get(Integer.valueOf(var5.field541));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "-990271773"
   )
   public HashMap method535() {
      this.method533();
      return this.field563;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIII)Lclass29;",
      garbageValue = "-1870819226"
   )
   class29 method536(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = var1 + this.field567;
      int var7 = var2 + this.field565;
      int var8 = var3 + this.field567;
      int var9 = this.field565 + var4;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field435 = var12 - var10 + 1;
      var5.field433 = var13 - var11 + 1;
      var5.field434 = var10 - this.field560.method293();
      var5.field432 = var11 - this.field560.method305();
      if(var5.field434 < 0) {
         var5.field435 += var5.field434;
         var5.field434 = 0;
      }

      if(var5.field434 > this.field569.length - var5.field435) {
         var5.field435 = this.field569.length - var5.field434;
      }

      if(var5.field432 < 0) {
         var5.field433 += var5.field432;
         var5.field432 = 0;
      }

      if(var5.field432 > this.field569[0].length - var5.field433) {
         var5.field433 = this.field569[0].length - var5.field432;
      }

      var5.field435 = Math.min(var5.field435, this.field569.length);
      var5.field433 = Math.min(var5.field433, this.field569[0].length);
      return var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "1566285358"
   )
   float method537(int var1, int var2) {
      float var3 = (float)var1 / (float)var2;
      if(var3 > 8.0F) {
         return 8.0F;
      } else if(var3 < 1.0F) {
         return 1.0F;
      } else {
         int var4 = Math.round(var3);
         return Math.abs((float)var4 - var3) < 0.05F?(float)var4:var3;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1138985801"
   )
   public boolean method552() {
      return this.field566;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIIB)Ljava/util/List;",
      garbageValue = "-13"
   )
   public List method561(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field566) {
         return var11;
      } else {
         class29 var12 = this.method536(var1, var2, var3, var4);
         float var13 = this.method537(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field567 + var1;
         int var16 = this.field565 + var2;

         for(int var17 = var12.field434; var17 < var12.field434 + var12.field435; ++var17) {
            for(int var18 = var12.field432; var18 < var12.field433 + var12.field432; ++var18) {
               List var19 = this.field569[var17][var18].method391(var5 + (this.field569[var17][var18].field483 * 64 - var15) * var14 / 64, var6 + var8 - var14 * (this.field569[var17][var18].field487 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   public class41(ModIcon[] var1, HashMap var2) {
      this.field566 = false;
      this.field558 = false;
      this.field564 = new HashMap();
      this.field568 = var1;
      this.field575 = var2;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;ILPlayer;IS)V",
      garbageValue = "1024"
   )
   static final void method572(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 4) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.readBytes(var6, 0, var5);
         class96.field1498[var1] = var7;
         var2.method1091(var7);
      }

      int var17;
      if((var3 & 64) != 0) {
         var5 = var0.readUnsignedShort();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var17 = var0.readUnsignedByte();
         class10.method57(var2, var5, var17);
      }

      if((var3 & 8) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 128) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            class5.sendGameMessage(2, var2.name, var2.overhead);
         } else if(var2 == class20.localPlayer) {
            class5.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field1222 = false;
         var2.field1225 = 0;
         var2.field1262 = 0;
         var2.field1234 = 150;
      }

      int var8;
      int var18;
      if((var3 & 2) != 0) {
         var5 = var0.readUnsignedByte();
         int var9;
         int var10;
         int var11;
         if(var5 > 0) {
            for(var17 = 0; var17 < var5; ++var17) {
               var9 = -1;
               var18 = -1;
               var8 = -1;
               var11 = var0.method3046();
               if(var11 == 32767) {
                  var11 = var0.method3046();
                  var18 = var0.method3046();
                  var9 = var0.method3046();
                  var8 = var0.method3046();
               } else if(var11 != 32766) {
                  var18 = var0.method3046();
               } else {
                  var11 = -1;
               }

               var10 = var0.method3046();
               var2.method1443(var11, var18, var9, var8, Client.gameCycle, var10);
            }
         }

         var17 = var0.readUnsignedByte();
         if(var17 > 0) {
            for(var11 = 0; var11 < var17; ++var11) {
               var9 = var0.method3046();
               var18 = var0.method3046();
               if(var18 != 32767) {
                  var8 = var0.method3046();
                  var10 = var0.readUnsignedByte();
                  int var12 = var18 > 0?var0.readUnsignedByte():var10;
                  var2.method1445(var9, Client.gameCycle, var18, var8, var10, var12);
               } else {
                  var2.method1446(var9);
               }
            }
         }
      }

      if((var3 & 32) != 0) {
         var2.field1236 = var0.readUnsignedShort();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1236;
            var2.field1236 = -1;
         }
      }

      if((var3 & 16) != 0) {
         var5 = var0.readUnsignedShort();
         class230[] var19 = new class230[]{class230.field3180, class230.field3178, class230.field3187, class230.field3182, class230.field3179, class230.field3181};
         class230 var20 = (class230)RSCanvas.method735(var19, var0.readUnsignedByte());
         boolean var23 = var0.readUnsignedByte() == 1;
         var18 = var0.readUnsignedByte();
         var8 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var22 = false;
            if(var20.field3186 && class87.method1604(var2.name)) {
               var22 = true;
            }

            if(!var22 && Client.field1025 == 0 && !var2.hidden) {
               class96.field1501.offset = 0;
               var0.readBytes(class96.field1501.payload, 0, var18);
               class96.field1501.offset = 0;
               Buffer var13 = class96.field1501;
               String var14 = class162.method2947(var13, 32767);
               String var15 = FontTypeFace.method4631(class210.method3816(var14));
               var2.overhead = var15.trim();
               var2.field1225 = var5 >> 8;
               var2.field1262 = var5 & 255;
               var2.field1234 = 150;
               var2.field1222 = var23;
               var2.inSequence = var2 != class20.localPlayer && var20.field3186 && "" != Client.field1124 && var15.toLowerCase().indexOf(Client.field1124) == -1;
               int var16;
               if(var20.field3185) {
                  var16 = var23?91:1;
               } else {
                  var16 = var23?90:2;
               }

               if(var20.field3184 != -1) {
                  class5.sendGameMessage(var16, RSCanvas.method741(var20.field3184) + var2.name, var15);
               } else {
                  class5.sendGameMessage(var16, var2.name, var15);
               }
            }
         }

         var0.offset = var18 + var8;
      }

      if((var3 & 2048) != 0) {
         var2.graphic = var0.readUnsignedShort();
         var5 = var0.readInt();
         var2.field1239 = var5 >> 16;
         var2.field1248 = Client.gameCycle + (var5 & '\uffff');
         var2.field1221 = 0;
         var2.field1247 = 0;
         if(var2.field1248 > Client.gameCycle) {
            var2.field1221 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 1024) != 0) {
         var2.field1250 = var0.readByte();
         var2.field1213 = var0.readByte();
         var2.field1256 = var0.readByte();
         var2.field1253 = var0.readByte();
         var2.field1254 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1259 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1261 = var0.readUnsignedShort();
         if(var2.field877) {
            var2.field1250 += var2.field887;
            var2.field1213 += var2.field888;
            var2.field1256 += var2.field887;
            var2.field1253 += var2.field888;
            var2.queueSize = 0;
         } else {
            var2.field1250 += var2.pathX[0];
            var2.field1213 += var2.pathY[0];
            var2.field1256 += var2.pathX[0];
            var2.field1253 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1267 = 0;
      }

      if((var3 & 256) != 0) {
         class96.field1494[var1] = var0.readByte();
      }

      if((var3 & 4096) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 512) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if(var2.field877) {
         if(var4 == 127) {
            var2.method1083(var2.field887, var2.field888);
         } else {
            byte var21;
            if(var4 != -1) {
               var21 = var4;
            } else {
               var21 = class96.field1494[var1];
            }

            var2.method1071(var2.field887, var2.field888, var21);
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass154;III)Lclass109;",
      garbageValue = "-1654314309"
   )
   public static final class109 method573(class154 var0, int var1, int var2) {
      if(class109.field1635 == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            class109 var3 = class90.field1395.vmethod1820();
            var3.field1639 = new int[(class222.field2849?2:1) * 256];
            var3.field1630 = var2;
            var3.vmethod1919();
            var3.field1629 = (var2 & -1024) + 1024;
            if(var3.field1629 > 16384) {
               var3.field1629 = 16384;
            }

            var3.vmethod1941(var3.field1629);
            if(class109.field1623 > 0 && class109.field1624 == null) {
               class109.field1624 = new class111();
               class109.field1621 = Executors.newScheduledThreadPool(1);
               class109.field1621.scheduleAtFixedRate(class109.field1624, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class109.field1624 != null) {
               if(class109.field1624.field1659[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class109.field1624.field1659[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new class109();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
