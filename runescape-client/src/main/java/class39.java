import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class39 {
   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "[Ljr;"
   )
   static IndexedSprite[] field538;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1591206879
   )
   static int field547;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   final class33 field541;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -979262267
   )
   public final int field544;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -688775409
   )
   int field536;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public final Coordinates field537;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public final Coordinates field542;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1365722419
   )
   final int field539;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1561651479
   )
   int field543;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1044757289
   )
   final int field540;

   @ObfuscatedSignature(
      signature = "(ILhh;Lhh;Laj;)V"
   )
   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field544 = var1;
      this.field537 = var2;
      this.field542 = var3;
      this.field541 = var4;
      Area var5 = Area.field3284[this.field544];
      SpritePixels var6 = var5.method4308(false);
      if(var6 != null) {
         this.field539 = var6.width;
         this.field540 = var6.height;
      } else {
         this.field539 = 0;
         this.field540 = 0;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2124218266"
   )
   boolean method558(int var1, int var2) {
      Area var3 = Area.field3284[this.field544];
      switch(var3.field3293.field3532) {
      case 0:
         if(var1 >= this.field536 && var1 < this.field539 + this.field536) {
            break;
         }

         return false;
      case 1:
         if(var1 > this.field536 - this.field539 && var1 <= this.field536) {
            break;
         }

         return false;
      case 2:
         if(var1 < this.field536 - this.field539 / 2 || var1 > this.field539 / 2 + this.field536) {
            return false;
         }
      }

      switch(var3.field3291.field3260) {
      case 0:
         if(var2 >= this.field543 - this.field540 / 2 && var2 <= this.field540 / 2 + this.field543) {
            break;
         }

         return false;
      case 1:
         if(var2 <= this.field543 - this.field540 || var2 > this.field543) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field543 || var2 >= this.field540 + this.field543) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1894229925"
   )
   boolean method559(int var1, int var2) {
      return this.field541 == null?false:(var1 >= this.field536 - this.field541.field477 / 2 && var1 <= this.field541.field477 / 2 + this.field536?var2 >= this.field543 && var2 <= this.field541.field479 + this.field543:false);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "20"
   )
   boolean method566(int var1, int var2) {
      return this.method558(var1, var2)?true:this.method559(var1, var2);
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(Lhi;IIII)V",
      garbageValue = "1917089906"
   )
   static final void method563(Widget var0, int var1, int var2, int var3) {
      class211 var4 = var0.method4043(false);
      if(var4 != null) {
         if(Client.field1160 < 3) {
            RSCanvas.compass.method5111(var1, var2, var4.field2599, var4.field2597, 25, 25, Client.mapAngle, 256, var4.field2595, var4.field2596);
         } else {
            Rasterizer2D.method4983(var1, var2, 0, var4.field2595, var4.field2596);
         }

      }
   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1924181575"
   )
   static final void method562() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            class43.method650(var0);
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "-1577868036"
   )
   static int method556(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class43.field582:class208.field2580;
      if(var0 == 1500) {
         class84.intStack[++class84.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 1501) {
         class84.intStack[++class84.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 1502) {
         class84.intStack[++class84.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         class84.intStack[++class84.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         class84.intStack[++class84.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         class84.intStack[++class84.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1669740978"
   )
   static void method564(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < ItemComposition.field3520; ++var4) {
         ItemComposition var5 = SoundTask.getItemDefinition(var4);
         if((!var1 || var5.field3508) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class22.field349 = -1;
               class212.field2607 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class212.field2607 = var2;
      class169.field2340 = 0;
      class22.field349 = var3;
      String[] var8 = new String[class22.field349];

      for(int var9 = 0; var9 < class22.field349; ++var9) {
         var8[var9] = SoundTask.getItemDefinition(var2[var9]).name;
      }

      class93.method1766(var8, class212.field2607);
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(Lhi;I)Z",
      garbageValue = "-444611098"
   )
   static final boolean method565(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field987 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1008.method3959(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1008.method3977(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1008.method3961(false);
         }

         if(var1 == 325) {
            Client.field1008.method3961(true);
         }

         if(var1 == 326) {
            Client.secretPacketBuffer1.putOpcode(23);
            Client.field1008.method3972(Client.secretPacketBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }
}
