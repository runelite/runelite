import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public enum class90 implements class185 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lcp;"
   )
   field1325(0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lcp;"
   )
   field1322(1),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lcp;"
   )
   field1324(2),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lcp;"
   )
   field1328(3);

   @ObfuscatedName("k")
   public static byte[][][] field1323;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2144822489
   )
   final int field1326;

   class90(int var3) {
      this.field1326 = var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int rsOrdinal() {
      return this.field1326;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Ljh;",
      garbageValue = "1844084988"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class17.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-531367195"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class89.method1681(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-47"
   )
   static final void method1683() {
      if(class226.soundSystem1 != null) {
         class226.soundSystem1.method2069();
      }

      if(class3.soundSystem0 != null) {
         class3.soundSystem0.method2069();
      }

   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "([Lhx;Lhx;ZI)V",
      garbageValue = "1066013089"
   )
   static void method1686(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      Widget.method4066(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         Widget.method4066(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         class86.method1670(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
