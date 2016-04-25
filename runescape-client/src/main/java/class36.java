import java.util.Calendar;
import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class36 {
   @ObfuscatedName("u")
   static class173 field775;
   @ObfuscatedName("z")
   static String[] field777;
   @ObfuscatedName("e")
   static int[][] field779 = new int[5][5000];
   @ObfuscatedName("i")
   static int[] field780 = new int[1000];
   @ObfuscatedName("c")
   static String[] field781 = new String[1000];
   @ObfuscatedName("d")
   static final String[] field782 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("l")
   static class14[] field783 = new class14[50];
   @ObfuscatedName("x")
   static int[] field784 = new int[5];
   @ObfuscatedName("a")
   static Calendar field785 = Calendar.getInstance();
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1110087725
   )
   static int field786 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1468923655
   )
   static int field787 = 0;
   @ObfuscatedName("pe")
   static short[] field789;
   @ObfuscatedName("m")
   static int[] field791;

   @ObfuscatedName("j")
   public static String method738(long var0) {
      class111.field1937.setTime(new Date(var0));
      int var2 = class111.field1937.get(7);
      int var3 = class111.field1937.get(5);
      int var4 = class111.field1937.get(2);
      int var5 = class111.field1937.get(1);
      int var6 = class111.field1937.get(11);
      int var7 = class111.field1937.get(12);
      int var8 = class111.field1937.get(13);
      return class111.field1939[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class111.field1935[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "707213493"
   )
   static final void method739(int var0, int var1) {
      int var2 = class95.field1606.method4002("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < client.field415; ++var3) {
         var4 = class95.field1606.method4002(class98.method2193(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = client.field415 * 15 + 22;
      var4 = var0 - var2 / 2;
      if(var2 + var4 > class5.field102) {
         var4 = class5.field102 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var1 + var3 > class39.field901) {
         var5 = class39.field901 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      client.field453 = true;
      class167.field2665 = var4;
      class28.field663 = var5;
      class18.field256 = var2;
      class93.field1585 = 22 + client.field415 * 15;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "0"
   )
   public static final void method740(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= '뮀') {
         class56.field1181 = var0;
         class113.field1944 = var1;
         class165.field2653 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }
}
