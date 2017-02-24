import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class1 {
   @ObfuscatedName("q")
   public final List field9;
   @ObfuscatedName("d")
   public static Comparator field10 = new class7();
   @ObfuscatedName("h")
   public static Comparator field11;
   @ObfuscatedName("j")
   public static Comparator field13;
   @ObfuscatedName("pe")
   static short[] field14;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -345150543
   )
   public static int field16;
   @ObfuscatedName("p")
   public static Comparator field20;
   @ObfuscatedName("af")
   static class184 field23;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "1488862155"
   )
   public void method14(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field9, var1);
      } else {
         Collections.sort(this.field9, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-83"
   )
   public static int method18(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class1(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field9 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field9.add(new class2(var1, var5, var3));
      }

   }

   static {
      new class0();
      field11 = new class5();
      field20 = new class6();
      field13 = new class3();
   }
}
