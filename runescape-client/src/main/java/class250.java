import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public enum class250 implements Enumerated {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   field3358(1, 0),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   field3359(0, 1),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   field3360(2, 2);

   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 40573605
   )
   public final int field3362;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1860558915
   )
   final int field3361;

   class250(int var3, int var4) {
      this.field3362 = var3;
      this.field3361 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "744101166"
   )
   public int rsOrdinal() {
      return this.field3361;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Liw;",
      garbageValue = "782642658"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.identKits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.identKit_ref.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         KitDefinition.identKits.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lis;",
      garbageValue = "-556052293"
   )
   public static class254 method4656(int var0) {
      class254 var1 = (class254)class254.field3399.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class254.field3400.getConfigData(19, var0);
         var1 = new class254();
         if(var2 != null) {
            var1.method4718(new Buffer(var2));
         }

         class254.field3399.put(var1, (long)var0);
         return var1;
      }
   }
}
