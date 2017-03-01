import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public final class class159 extends Buffer {
   @ObfuscatedName("i")
   static final int[] field2118 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("a")
   class160 field2119;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 175665357
   )
   int field2120;
   @ObfuscatedName("q")
   static int[][][] field2122;

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "443646663"
   )
   public void method3143(int[] var1) {
      this.field2119 = new class160(var1);
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "509157833"
   )
   public void method3144(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2119.method3174());
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "622818194"
   )
   public int method3147(int var1) {
      int var2 = this.field2120 >> 3;
      int var3 = 8 - (this.field2120 & 7);
      int var4 = 0;

      for(this.field2120 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2118[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2118[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2118[var1];
      }

      return var4;
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1235488241"
   )
   public void method3148() {
      super.offset = (7 + this.field2120) / 8;
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1674328634"
   )
   public int method3149(int var1) {
      return 8 * var1 - this.field2120;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1254506332"
   )
   public static int method3151(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var2 * var0;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1104764304"
   )
   public int method3158() {
      return super.payload[++super.offset - 1] - this.field2119.method3174() & 255;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "-1304028846"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field3008.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3036.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.method3799(new Buffer(var2));
         }

         var1.method3778();
         NPCComposition.field3008.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-20"
   )
   public static void method3164() {
      Varbit.field2857.reset();
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1147633526"
   )
   public void method3165() {
      this.field2120 = super.offset * 8;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class159(int var1) {
      super(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)I",
      garbageValue = "382953420"
   )
   static int method3166(class182 var0, class182 var1) {
      int var2 = 0;
      if(var0.method3372("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3372("logo", "")) {
         ++var2;
      }

      if(var1.method3372("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3372("titlebox", "")) {
         ++var2;
      }

      if(var1.method3372("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3372("runes", "")) {
         ++var2;
      }

      if(var1.method3372("title_mute", "")) {
         ++var2;
      }

      if(var1.method3373("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3373("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3372("sl_back", "");
      var1.method3372("sl_flags", "");
      var1.method3372("sl_arrows", "");
      var1.method3372("sl_stars", "");
      var1.method3372("sl_button", "");
      return var2;
   }
}
