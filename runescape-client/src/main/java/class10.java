import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public final class class10 extends class9 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1864000131
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = -2001195991
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -1467917035
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 344777515
   )
   final int field249;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -781544715
   )
   final int field243;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1824126255
   )
   final int field241;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1331369649
   )
   final int field245;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -51412327
   )
   final int field242;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -130304675
   )
   final int field246;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -788753823
   )
   final int field240;

   @ObfuscatedSignature(
      signature = "(Leo;IIII)V"
   )
   class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field249 = var2 + var1.field1896 - var1.field1913;
      this.field241 = var3 + var1.field1911 - var1.field1917;
      this.field242 = var4 + var1.field1912 - var1.field1901;
      this.field243 = var2 + var1.field1896 + var1.field1913;
      this.field245 = var1.field1911 + var3 + var1.field1917;
      this.field246 = var4 + var1.field1912 + var1.field1901;
      this.field240 = var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-23"
   )
   public final void vmethod49() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.field249:this.field243;
         int var2 = (var4 & 2) == 0?this.field241:this.field245;
         int var3 = (var4 & 4) == 0?this.field242:this.field246;
         if((var4 & 1) == 0) {
            class207.method3821(var1, var2, var3, this.field243, var2, var3, this.field240);
         }

         if((var4 & 2) == 0) {
            class207.method3821(var1, var2, var3, var1, this.field245, var3, this.field240);
         }

         if((var4 & 4) == 0) {
            class207.method3821(var1, var2, var3, var1, var2, this.field246, this.field240);
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Lic;",
      garbageValue = "56"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = InvType.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.method4470(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method4479(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.field3492 != -1) {
            var1.method4447(getItemDefinition(var1.field3492), getItemDefinition(var1.field3516));
         }

         if(!IndexFile.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3513 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field3511 = 0;
            if(var1.field3512 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3512.method3456(); var4 != null; var4 = var1.field3512.method3442()) {
                  class251 var5 = Varbit.method4309((int)var4.hash);
                  if(var5.field3361) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3512 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method51() {
      FileOnDisk var0 = null;

      try {
         var0 = WallObject.getPreferencesFile("", class98.field1497.field3159, true);
         Buffer var1 = class34.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var2) {
         ;
      }

   }
}
