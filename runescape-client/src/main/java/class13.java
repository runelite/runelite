import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class13 {
   @ObfuscatedName("i")
   public final List field277;
   @ObfuscatedName("h")
   public static Comparator field278;
   @ObfuscatedName("q")
   public static Comparator field280;
   @ObfuscatedName("g")
   public static Comparator field281;
   @ObfuscatedName("u")
   public static Comparator field282;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILIndexDataBase;IIIZI)V",
      garbageValue = "2058556693"
   )
   public static void method62(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class203.field2498 = 1;
      Varbit.field3380 = var1;
      class169.field2325 = var2;
      class203.field2499 = var3;
      class203.field2500 = var4;
      class203.field2495 = var5;
      class203.field2501 = var0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-1863258936"
   )
   public void method63(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field277, var1);
      } else {
         Collections.sort(this.field277, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class13(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field277 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field277.add(new class14(var1, var5, var3));
      }

   }

   static {
      field278 = new class19();
      new class12();
      field282 = new class17();
      field280 = new class18();
      field281 = new class15();
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-705136665"
   )
   static final void method66(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class14.method75(var0)) {
         class29.field416 = null;
         class33.gameDraw(class90.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class29.field416 != null) {
            class33.gameDraw(class29.field416, -1412584499, var1, var2, var3, var4, XClanMember.field886, class51.field648, var7);
            class29.field416 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1095[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1095[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "(IZZZB)LIndexData;",
      garbageValue = "-17"
   )
   static IndexData method68(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class155.field2231 != null) {
         var4 = new IndexFile(var0, class155.field2231, VertexNormal.field1994[var0], 1000000);
      }

      return new IndexData(var4, class61.field759, var0, var1, var2, var3);
   }
}
