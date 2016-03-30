import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("Tile")
public final class class101 extends class208 {
   @ObfuscatedName("d")
   boolean field1747;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1418936729
   )
   @Export("x")
   int field1748;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -537487463
   )
   int field1749;
   @ObfuscatedName("l")
   @Export("itemLayer")
   class99 field1750;
   @ObfuscatedName("e")
   class89 field1751;
   @ObfuscatedName("y")
   class97 field1752;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -73637203
   )
   int field1753;
   @ObfuscatedName("c")
   class94 field1754;
   @ObfuscatedName("v")
   class93 field1755;
   @ObfuscatedName("dz")
   static int[] field1756;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 967750503
   )
   int field1757;
   @ObfuscatedName("s")
   @Export("objects")
   class98[] field1758 = new class98[5];
   @ObfuscatedName("j")
   int[] field1759 = new int[5];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1989611255
   )
   int field1761;
   @ObfuscatedName("m")
   class87 field1762;
   @ObfuscatedName("u")
   boolean field1763;
   @ObfuscatedName("i")
   boolean field1764;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1016079455
   )
   int field1765;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 581797123
   )
   @Export("plane")
   int field1766;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1913083259
   )
   int field1767;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -554909043
   )
   int field1768;
   @ObfuscatedName("r")
   class101 field1769;
   @ObfuscatedName("pg")
   static class134 field1770;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -764307335
   )
   @Export("y")
   int field1771;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1306014611
   )
   int field1772 = 0;

   @ObfuscatedName("w")
   public static void method2280(class167 var0) {
      class46.field1061 = var0;
   }

   class101(int var1, int var2, int var3) {
      this.field1749 = this.field1766 = var1;
      this.field1748 = var2;
      this.field1771 = var3;
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1430066626"
   )
   static final void method2281(String var0) {
      if(var0 != null) {
         if((client.field565 < 100 || client.field409 == 1) && client.field565 < 400) {
            String var1 = class142.method2997(var0, class164.field2678);
            if(null != var1) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < client.field565; ++var2) {
                  class7 var3 = client.field566[var2];
                  var4 = class142.method2997(var3.field146, class164.field2678);
                  if(null != var4 && var4.equals(var1)) {
                     class103.method2289(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(null != var3.field140) {
                     var5 = class142.method2997(var3.field140, class164.field2678);
                     if(var5 != null && var5.equals(var1)) {
                        class103.method2289(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < client.field561; ++var2) {
                  class17 var6 = client.field474[var2];
                  var4 = class142.method2997(var6.field260, class164.field2678);
                  if(var4 != null && var4.equals(var1)) {
                     class103.method2289(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(null != var6.field254) {
                     var5 = class142.method2997(var6.field254, class164.field2678);
                     if(null != var5 && var5.equals(var1)) {
                        class103.method2289(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class142.method2997(class167.field2692.field59, class164.field2678).equals(var1)) {
                  class103.method2289(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  client.field318.method2757(205);
                  client.field318.method2573(class45.method992(var0));
                  client.field318.method2661(var0);
               }
            }
         } else {
            class103.method2289(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }
}
