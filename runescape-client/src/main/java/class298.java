import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
public class class298 extends NameableContainer {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -671774427
   )
   static int field3830;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   final JagexLoginType field3829;

   @ObfuscatedSignature(
      signature = "(Llt;)V"
   )
   public class298(JagexLoginType var1) {
      super(400);
      this.field3829 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lkm;",
      garbageValue = "-2116343302"
   )
   Nameable vmethod5562() {
      return new Ignore();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)[Lkm;",
      garbageValue = "164976155"
   )
   Nameable[] vmethod5575(int var1) {
      return new Ignore[var1];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "1568876260"
   )
   public void method5398(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            int var3 = var1.readUnsignedByte();
            boolean var4 = (var3 & 1) == 1;
            Name var5 = new Name(var1.readString(), this.field3829);
            Name var6 = new Name(var1.readString(), this.field3829);
            var1.readString();
            if(var5 != null && var5.method5533()) {
               Ignore var7 = (Ignore)this.method5414(var4?var6:var5);
               if(var7 != null) {
                  this.method5437(var7, var5, var6);
                  continue;
               }

               if(this.getCount() < 400) {
                  int var8 = this.getCount();
                  var7 = (Ignore)this.method5467(var5, var6);
                  var7.field3837 = var8;
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "52784742"
   )
   static int method5395(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class5.getWidget(class81.intStack[--class81.intStackSize]);
      } else {
         var3 = var2?class20.field338:class81.field1267;
      }

      class171.method3363(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class81.intStack[--class81.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = TotalQuantityComparator.localPlayer.composition.method4519();
            return 1;
         } else {
            return 2;
         }
      } else {
         class81.intStackSize -= 2;
         int var4 = class81.intStack[class81.intStackSize];
         int var5 = class81.intStack[class81.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = class251.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2874 = var6.offsetX2d;
         var3.field2875 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2958 = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.field2958 = 1;
         } else {
            var3.field2958 = 2;
         }

         if(var3.field2880 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2880;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }
}
