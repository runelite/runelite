import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class39 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1481683381
   )
   public final int field513;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public final Coordinates field506;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public final Coordinates field507;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1974303923
   )
   final int field505;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -859680577
   )
   final int field508;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   final class33 field510;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -335187449
   )
   int field509;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -129877575
   )
   int field512;

   @ObfuscatedSignature(
      signature = "(ILhp;Lhp;Lae;)V"
   )
   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field513 = var1;
      this.field507 = var2;
      this.field506 = var3;
      this.field510 = var4;
      Area var5 = Area.mapAreaType[this.field513];
      SpritePixels var6 = var5.getMapIcon(false);
      if(var6 != null) {
         this.field505 = var6.width;
         this.field508 = var6.height;
      } else {
         this.field505 = 0;
         this.field508 = 0;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "1"
   )
   boolean method553(int var1, int var2) {
      return this.method541(var1, var2)?true:this.method542(var1, var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-88"
   )
   boolean method541(int var1, int var2) {
      Area var3 = Area.mapAreaType[this.field513];
      switch(var3.field3380.field3609) {
      case 0:
         if(var1 >= this.field509 - this.field505 / 2 && var1 <= this.field505 / 2 + this.field509) {
            break;
         }

         return false;
      case 1:
         if(var1 <= this.field509 - this.field505 || var1 > this.field509) {
            return false;
         }
         break;
      case 2:
         if(var1 < this.field509 || var1 >= this.field505 + this.field509) {
            return false;
         }
      }

      switch(var3.field3379.field3345) {
      case 0:
         if(var2 > this.field512 - this.field508 && var2 <= this.field512) {
            break;
         }

         return false;
      case 1:
         if(var2 < this.field512 - this.field508 / 2 || var2 > this.field508 / 2 + this.field512) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field512 || var2 >= this.field508 + this.field512) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1072987654"
   )
   boolean method542(int var1, int var2) {
      return this.field510 == null?false:(var1 >= this.field509 - this.field510.field441 / 2 && var1 <= this.field510.field441 / 2 + this.field509?var2 >= this.field512 && var2 <= this.field510.field445 + this.field512:false);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   public static final void method554() {
      while(true) {
         BoundingBox var0 = (BoundingBox)class7.boundingBoxes.removeLast();
         if(var0 == null) {
            return;
         }

         var0.draw();
      }
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1431598378"
   )
   static final void method551() {
      Region.lowMemory = false;
      Client.lowMemory = false;
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(Lhx;I)V",
      garbageValue = "-236648801"
   )
   static final void method548(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field1104 == -1) {
            Client.field1104 = var0.spriteId;
            Client.field1127 = var0.field2764;
         }

         if(Client.field1125.isFemale) {
            var0.spriteId = Client.field1104;
         } else {
            var0.spriteId = Client.field1127;
         }

      } else if(var1 == 325) {
         if(Client.field1104 == -1) {
            Client.field1104 = var0.spriteId;
            Client.field1127 = var0.field2764;
         }

         if(Client.field1125.isFemale) {
            var0.spriteId = Client.field1127;
         } else {
            var0.spriteId = Client.field1104;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(Lbr;ZI)V",
      garbageValue = "1223105083"
   )
   static final void method552(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1 && var2 != -1 && class56.validInterfaces[var2]) {
         ItemContainer.widgetIndex.method4278(var2);
         if(class11.widgets[var2] != null) {
            boolean var6 = true;

            for(int var5 = 0; var5 < class11.widgets[var2].length; ++var5) {
               if(class11.widgets[var2][var5] != null) {
                  if(class11.widgets[var2][var5].type != 2) {
                     class11.widgets[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               class11.widgets[var2] = null;
            }

            class56.validInterfaces[var2] = false;
         }
      }

      class236.method4243(var2);
      Widget var4 = class87.getWidget(var3);
      if(var4 != null) {
         class40.method556(var4);
      }

      ContextMenuRow.method1764();
      if(Client.widgetRoot != -1) {
         GrandExchangeEvent.method88(Client.widgetRoot, 1);
      }

   }
}
