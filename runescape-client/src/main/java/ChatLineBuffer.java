import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 509007675
   )
   @Export("length")
   int length;
   @ObfuscatedName("jt")
   static Widget[] field963;
   @ObfuscatedName("d")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "1455815932"
   )
   MessageNode method901(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "697351712"
   )
   int method902() {
      return this.length;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)LMessageNode;",
      garbageValue = "0"
   )
   MessageNode method904(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.method2483();
         var5.method215(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1891902340"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class166.plane][var0][var1];
      if(null == var2) {
         class157.region.method1780(class166.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method2466(); var6 != null; var6 = (Item)var2.method2461()) {
            ItemComposition var7 = class18.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(1 + var6.quantity);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class157.region.method1780(class166.plane, var0, var1);
         } else {
            var2.method2455(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method2466(); var6 != null; var6 = (Item)var2.method2461()) {
               if(var6.id != var5.id) {
                  if(null == var11) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && null == var10) {
                     var10 = var6;
                  }
               }
            }

            int var9 = (var1 << 7) + var0 + 1610612736;
            class157.region.method1747(class166.plane, var0, var1, class11.method161(128 * var0 + 64, 64 + var1 * 128, class166.plane), var5, var9, var11, var10);
         }
      }
   }
}
