import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class1 {
   @ObfuscatedName("y")
   public static Comparator field6 = new class7();
   @ObfuscatedName("o")
   public static Comparator field7;
   @ObfuscatedName("r")
   public static Comparator field8;
   @ObfuscatedName("j")
   public static class182 field10;
   @ObfuscatedName("d")
   static ModIcon field11;
   @ObfuscatedName("h")
   static String field12;
   @ObfuscatedName("w")
   public static Comparator field14;
   @ObfuscatedName("k")
   public final List field19;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZB)V",
      garbageValue = "0"
   )
   public void method15(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field19, var1);
      } else {
         Collections.sort(this.field19, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1848194096"
   )
   static final void method16() {
      if(Client.field331 > 0) {
         class114.method2188();
      } else {
         class11.setGameState(40);
         class167.field2308 = class177.field2657;
         class177.field2657 = null;
      }
   }

   static {
      new class0();
      field7 = new class5();
      field8 = new class6();
      field14 = new class3();
   }

   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1412053086"
   )
   static boolean method20(String var0) {
      if(null == var0) {
         return false;
      } else {
         String var1 = Overlay.method3751(var0, Client.field282);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(Overlay.method3751(var3.name, Client.field282))) {
               return true;
            }

            if(var1.equalsIgnoreCase(Overlay.method3751(var3.previousName, Client.field282))) {
               return true;
            }
         }

         return false;
      }
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
      this.field19 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field19.add(new class2(var1, var5, var3));
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "296340394"
   )
   static boolean method21(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }
}
