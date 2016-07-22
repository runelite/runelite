import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("MessageNode")
public class class37 extends class207 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2023452699
   )
   @Export("tick")
   int field805;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 562872851
   )
   @Export("type")
   int field806;
   @ObfuscatedName("g")
   @Export("sender")
   String field808;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1546785459
   )
   @Export("id")
   int field809;
   @ObfuscatedName("o")
   @Export("name")
   String field811;
   @ObfuscatedName("l")
   @Export("value")
   String field812;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1815569340"
   )
   void method755(int var1, String var2, String var3, String var4) {
      int var5 = ++class11.field159 - 1;
      this.field809 = var5;
      this.field805 = client.field282;
      this.field806 = var1;
      this.field811 = var2;
      this.field808 = var3;
      this.field812 = var4;
   }

   class37(int var1, String var2, String var3, String var4) {
      int var5 = ++class11.field159 - 1;
      this.field809 = var5;
      this.field805 = client.field282;
      this.field806 = var1;
      this.field811 = var2;
      this.field808 = var3;
      this.field812 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-284102665"
   )
   public static void method759() {
      class49.field1088.method3814();
      class49.field1098.method3814();
   }
}
