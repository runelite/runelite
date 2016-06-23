import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("MessageNode")
public class class35 extends class204 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 956167159
   )
   @Export("tick")
   int field786;
   @ObfuscatedName("b")
   @Export("name")
   String field789;
   @ObfuscatedName("l")
   @Export("sender")
   String field790;
   @ObfuscatedName("d")
   @Export("value")
   String field791;
   @ObfuscatedName("mm")
   @Export("clanMembers")
   static class24[] field792;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1885466685
   )
   @Export("id")
   int field793 = class74.method1648();
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1578329993
   )
   @Export("type")
   int field794;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "759474219"
   )
   public static int method771(String var0) {
      return var0.length() + 2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-285097819"
   )
   public static int method772(CharSequence var0) {
      return class107.method2430(var0, 10, true);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZB)[B",
      garbageValue = "-66"
   )
   public static byte[] method774(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class104.method2349(var3):var3;
      } else if(var0 instanceof class125) {
         class125 var2 = (class125)var0;
         return var2.vmethod2817();
      } else {
         throw new IllegalArgumentException();
      }
   }

   class35(int var1, String var2, String var3, String var4) {
      this.field786 = client.field301;
      this.field794 = var1;
      this.field789 = var2;
      this.field790 = var3;
      this.field791 = var4;
   }

   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2123499543"
   )
   static final void method775() {
      client.field333.method2773(114);
      client.field333.method2654(0);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "114"
   )
   void method776(int var1, String var2, String var3, String var4) {
      this.field793 = class74.method1648();
      this.field786 = client.field301;
      this.field794 = var1;
      this.field789 = var2;
      this.field790 = var3;
      this.field791 = var4;
   }
}
