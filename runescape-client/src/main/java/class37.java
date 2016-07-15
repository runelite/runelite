import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("MessageNode")
public class class37 extends class207 {
   @ObfuscatedName("r")
   @Export("sender")
   String field829;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2072427027
   )
   @Export("type")
   int field830;
   @ObfuscatedName("h")
   @Export("name")
   String field831;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1483808741
   )
   @Export("tick")
   int field832;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -496260323
   )
   @Export("id")
   int field833 = class180.method3552();
   @ObfuscatedName("a")
   @Export("value")
   String field835;

   class37(int var1, String var2, String var3, String var4) {
      this.field832 = client.field567;
      this.field830 = var1;
      this.field831 = var2;
      this.field829 = var3;
      this.field835 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-642071360"
   )
   static final int method771(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var0 / 4 << 10) + (var1 / 32 << 7);
      return var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1037433379"
   )
   void method773(int var1, String var2, String var3, String var4) {
      this.field833 = class180.method3552();
      this.field832 = client.field567;
      this.field830 = var1;
      this.field831 = var2;
      this.field829 = var3;
      this.field835 = var4;
   }
}
