import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("MessageNode")
public class class35 extends class204 {
   @ObfuscatedName("d")
   @Export("sender")
   String field786;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -179131551
   )
   @Export("type")
   int field787;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1726307555
   )
   int field789 = class177.method3442();
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -245454633
   )
   int field790;
   @ObfuscatedName("u")
   @Export("value")
   String field791;
   @ObfuscatedName("x")
   String field795;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1490750863"
   )
   void method713(int var1, String var2, String var3, String var4) {
      this.field789 = class177.method3442();
      this.field790 = client.field335;
      this.field787 = var1;
      this.field795 = var2;
      this.field786 = var3;
      this.field791 = var4;
   }

   class35(int var1, String var2, String var3, String var4) {
      this.field790 = client.field335;
      this.field787 = var1;
      this.field795 = var2;
      this.field786 = var3;
      this.field791 = var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass167;IIB)Z",
      garbageValue = "32"
   )
   public static boolean method714(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3239(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class174.method3426(var3);
         return true;
      }
   }
}
