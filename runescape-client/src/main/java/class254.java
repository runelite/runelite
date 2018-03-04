import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
public enum class254 implements Enumerated {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3324(7, 0),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3315(0, 1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3316(3, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3317(5, 3),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3318(2, 4),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3319(1, 5),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3320(4, 6),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3321(6, 7);

   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -638676471
   )
   public final int field3322;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -782169213
   )
   final int field3323;

   class254(int var3, int var4) {
      this.field3322 = var3;
      this.field3323 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "846888120"
   )
   public int rsOrdinal() {
      return this.field3323;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljk;Ljava/lang/String;Ljava/lang/String;I)[Llv;",
      garbageValue = "1195752699"
   )
   @Export("getIndexedSprites")
   public static IndexedSprite[] getIndexedSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite[] var5;
      if(!AbstractByteBuffer.method3843(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class237.method4477();
      }

      return var5;
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(Lbk;B)V",
      garbageValue = "94"
   )
   static final void method4644(Actor var0) {
      if(var0.field1183 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < 32768) {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= 32768) {
               var1 = Client.cachedPlayers[var0.interacting - 32768];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field1166) {
               var0.interacting = -1;
               var0.field1166 = false;
            }
         }

         if(var0.field1142 != -1 && (var0.queueSize == 0 || var0.field1197 > 0)) {
            var0.orientation = var0.field1142;
            var0.field1142 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field1166) {
            var0.interacting = -1;
            var0.field1166 = false;
         }

         if(var4 != 0) {
            ++var0.field1191;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field1183;
               var6 = true;
               if(var4 < var0.field1183 || var4 > 2048 - var0.field1183) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1191 > 25 || var6)) {
                  if(var0.field1145 != -1) {
                     var0.poseAnimation = var0.field1145;
                  } else {
                     var0.poseAnimation = var0.field1163;
                  }
               }
            } else {
               var0.angle += var0.field1183;
               var6 = true;
               if(var4 < var0.field1183 || var4 > 2048 - var0.field1183) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1191 > 25 || var6)) {
                  if(var0.field1148 != -1) {
                     var0.poseAnimation = var0.field1148;
                  } else {
                     var0.poseAnimation = var0.field1163;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1191 = 0;
         }

      }
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(Lbg;ZI)V",
      garbageValue = "97643283"
   )
   static final void method4639(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class95.method2042(var2);
      }

      class22.method174(var2);
      Widget var4 = class5.getWidget(var3);
      if(var4 != null) {
         class171.method3363(var4);
      }

      IndexStoreActionHandler.method4767();
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class18.loadWidget(var5)) {
            CombatInfo1.method1644(Widget.widgets[var5], 1);
         }
      }

   }
}
