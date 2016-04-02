import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("c")
@Implements("Friend")
public class class17 {
   @ObfuscatedName("h")
   boolean field240;
   @ObfuscatedName("p")
   boolean field241;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1223548607
   )
   @Export("world")
   int field242;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -710632243
   )
   int field244;
   @ObfuscatedName("w")
   @Export("previousName")
   String field245;
   @ObfuscatedName("bd")
   static class168 field246;
   @ObfuscatedName("e")
   @Export("name")
   String field247;

   @ObfuscatedName("cr")
   static final void method182(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class113.method2462(var0)) {
         class13.field201 = null;
         class119.method2547(class173.field2837[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(null != class13.field201) {
            class119.method2547(class13.field201, -1412584499, var1, var2, var3, var4, class25.field612, class59.field1193, var7);
            class13.field201 = null;
         }

      } else {
         if(-1 != var7) {
            client.field483[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               client.field483[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("av")
   static void method183() {
      client.field321.method2762(244);
      client.field321.method2565(class89.method2098());
      client.field321.method2713(class35.field762);
      client.field321.method2713(class21.field575);
   }
}
