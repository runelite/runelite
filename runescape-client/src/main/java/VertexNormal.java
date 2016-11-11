import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ce")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1967602669
   )
   int field1683;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1484712819
   )
   int field1684;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -545016947
   )
   int field1685;
   @ObfuscatedName("n")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("bu")
   static class171 field1688;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1701116389
   )
   int field1689;

   VertexNormal(VertexNormal var1) {
      this.field1689 = var1.field1689;
      this.field1684 = var1.field1684;
      this.field1685 = var1.field1685;
      this.field1683 = var1.field1683;
   }

   @ObfuscatedName("h")
   static final void method2241(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   VertexNormal() {
   }
}
