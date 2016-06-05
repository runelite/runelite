import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("MessageNode")
public class class35 extends class204 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 134256009
   )
   @Export("tick")
   int field776;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -612676101
   )
   @Export("type")
   int field777;
   @ObfuscatedName("h")
   @Export("name")
   String field778;
   @ObfuscatedName("z")
   @Export("sender")
   String field779;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1687811059
   )
   @Export("id")
   int field780;
   @ObfuscatedName("er")
   static class80[] field781;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1776855889
   )
   static int field782;
   @ObfuscatedName("r")
   @Export("value")
   String field784;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-707908630"
   )
   void method719(int var1, String var2, String var3, String var4) {
      int var5 = ++class11.field172 - 1;
      this.field780 = var5;
      this.field776 = client.field332;
      this.field777 = var1;
      this.field778 = var2;
      this.field779 = var3;
      this.field784 = var4;
   }

   class35(int var1, String var2, String var3, String var4) {
      int var5 = ++class11.field172 - 1;
      this.field780 = var5;
      this.field776 = client.field332;
      this.field777 = var1;
      this.field778 = var2;
      this.field779 = var3;
      this.field784 = var4;
   }
}
