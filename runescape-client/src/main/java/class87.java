import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("FaceNormal")
public class class87 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2104023327
   )
   int field1520;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1689989059
   )
   int field1521;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 693142887
   )
   int field1522;
   @ObfuscatedName("h")
   static class170 field1525;

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "510735180"
   )
   static void method1995() {
      client.field336.method2854(243);
      class125 var0 = client.field336;
      int var1 = client.field509?2:1;
      var0.method2795(var1);
      client.field336.method2781(class142.field2191);
      client.field336.method2781(class132.field2109);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILclass170;IIIZI)V",
      garbageValue = "-1793369926"
   )
   public static void method1996(int var0, class170 var1, int var2, int var3, int var4, boolean var5) {
      class186.field2993 = 1;
      class186.field2998 = var1;
      class119.field2041 = var2;
      class145.field2223 = var3;
      class28.field695 = var4;
      class102.field1760 = var5;
      class186.field2999 = var0;
   }
}
