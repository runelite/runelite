import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
final class class18 implements Comparator {
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 1918750301
   )
   static int field309;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static IndexDataBase field312;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = -370190445
   )
   @Export("menuHeight")
   static int menuHeight;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lk;Lk;I)I",
      garbageValue = "1607481073"
   )
   int method145(class14 var1, class14 var2) {
      return var1.method96().compareTo(var2.method96());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method145((class14)var1, (class14)var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Len;IIIII)V",
      garbageValue = "-631560789"
   )
   static final void method158(Model var0, int var1, int var2, int var3, int var4) {
      class7.field228.method3749(new class10(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1979059223"
   )
   static final void method157(String var0) {
      if(!var0.equals("")) {
         class170 var1 = Actor.method1628(ClientPacket.field2376, Client.field952.field1478);
         var1.field2423.putByte(Projectile.getLength(var0));
         var1.field2423.putString(var0);
         Client.field952.method1951(var1);
      }
   }
}
