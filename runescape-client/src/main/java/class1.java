import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class1 {
   @ObfuscatedName("c")
   public static Comparator field11;
   @ObfuscatedName("n")
   public static Comparator field12;
   @ObfuscatedName("q")
   public static Comparator field13;
   @ObfuscatedName("t")
   public static Comparator field14;
   @ObfuscatedName("d")
   public final List field15;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 2019010125
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 920665721
   )
   @Export("menuY")
   static int menuY;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-983407984"
   )
   static void method15(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      class183 var4 = (class183)class187.field2771.method2773(var2);
      if(var4 != null) {
         class187.field2758.method2714(var4);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "2113961692"
   )
   public void method16(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field15, var1);
      } else {
         Collections.sort(this.field15, Collections.reverseOrder(var1));
      }

   }

   static {
      field11 = new class7();
      new class0();
      field12 = new class5();
      field13 = new class6();
      field14 = new class3();
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
      this.field15 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field15.add(new class2(var1, var5, var3));
      }

   }
}
