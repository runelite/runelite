import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class40 implements class134 {
   @ObfuscatedName("ek")
   static ModIcon[] field804;
   @ObfuscatedName("c")
   static final class40 field805;
   @ObfuscatedName("n")
   static final class40 field806;
   @ObfuscatedName("q")
   static final class40 field807;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1134393975
   )
   final int field808;
   @ObfuscatedName("d")
   static final class40 field809;

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1881606954"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[Client.plane][var0][var1];
      if(var2 == null) {
         class172.region.method1801(Client.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method2828(); var6 != null; var6 = (Item)var2.method2830()) {
            ItemComposition var7 = class47.getItemDefinition(var6.id);
            long var10 = (long)var7.price;
            if(var7.isStackable == 1) {
               var10 *= (long)(var6.quantity + 1);
            }

            if(var10 > var3) {
               var3 = var10;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class172.region.method1801(Client.plane, var0, var1);
         } else {
            var2.method2843(var5);
            Item var12 = null;
            Item var8 = null;

            for(var6 = (Item)var2.method2828(); var6 != null; var6 = (Item)var2.method2830()) {
               if(var5.id != var6.id) {
                  if(var12 == null) {
                     var12 = var6;
                  }

                  if(var6.id != var12.id && var8 == null) {
                     var8 = var6;
                  }
               }
            }

            int var9 = (var1 << 7) + var0 + 1610612736;
            class172.region.method1749(Client.plane, var0, var1, CombatInfo1.method600(var0 * 128 + 64, var1 * 128 + 64, Client.plane), var5, var9, var12, var8);
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1946751124"
   )
   public int vmethod4163() {
      return this.field808;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class40(int var1) {
      this.field808 = var1;
   }

   static {
      field809 = new class40(0);
      field805 = new class40(1);
      field806 = new class40(2);
      field807 = new class40(3);
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-59"
   )
   static void method780(int var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(192);
      Client.secretPacketBuffer1.method2416(var1);
      Client.secretPacketBuffer1.putInt(var0);
   }
}
