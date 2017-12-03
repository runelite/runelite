import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("i")
   static String[] field298;
   @ObfuscatedName("b")
   @Export("osName")
   static String osName;
   @ObfuscatedName("a")
   @Export("progress")
   byte progress;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 420374037
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -940633443
   )
   @Export("price")
   public int price;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1993245439
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -616978795
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 300076227
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lgh;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1570598414"
   )
   @Export("status")
   public int status() {
      return this.progress & 7;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   @Export("type")
   public int type() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "84"
   )
   void method99(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1571324617"
   )
   void method95(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-155028062"
   )
   static void method112() {
      class96.chatLineMap.clear();
      class96.messages.clear();
      class96.field1414.clear();
      class96.field1416 = 0;
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(Lbr;I)V",
      garbageValue = "-1682729722"
   )
   static final void method111(Actor var0) {
      if(var0.field1175 != 0) {
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
            } else if(var0.field1149) {
               var0.interacting = -1;
               var0.field1149 = false;
            }
         }

         if(var0.field1150 != -1 && (var0.queueSize == 0 || var0.field1180 > 0)) {
            var0.orientation = var0.field1150;
            var0.field1150 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field1149) {
            var0.interacting = -1;
            var0.field1149 = false;
         }

         if(var4 != 0) {
            ++var0.field1174;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field1175;
               var6 = true;
               if(var4 < var0.field1175 || var4 > 2048 - var0.field1175) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1174 > 25 || var6)) {
                  if(var0.field1128 != -1) {
                     var0.poseAnimation = var0.field1128;
                  } else {
                     var0.poseAnimation = var0.field1139;
                  }
               }
            } else {
               var0.angle += var0.field1175;
               var6 = true;
               if(var4 < var0.field1175 || var4 > 2048 - var0.field1175) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1174 > 25 || var6)) {
                  if(var0.field1176 != -1) {
                     var0.poseAnimation = var0.field1176;
                  } else {
                     var0.poseAnimation = var0.field1139;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1174 = 0;
         }

      }
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "([Lhz;Lhz;ZB)V",
      garbageValue = "-96"
   )
   static void method102(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class239.method4227(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class239.method4227(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         ScriptEvent.method1055(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
