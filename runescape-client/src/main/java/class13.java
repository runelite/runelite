import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class13 {
   @ObfuscatedName("h")
   public static Comparator field274;
   @ObfuscatedName("z")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("f")
   public static Comparator field283;
   @ObfuscatedName("p")
   public static Comparator field276;
   @ObfuscatedName("x")
   public static Comparator field275;
   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "[Lkp;"
   )
   @Export("pkIcons")
   static SpritePixels[] pkIcons;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -1283223689
   )
   static int field278;
   @ObfuscatedName("j")
   public final List field282;

   static {
      field274 = new class19();
      new class12();
      field283 = new class17();
      field276 = new class18();
      field275 = new class15();
   }

   @ObfuscatedSignature(
      signature = "(Lfb;Z)V",
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
      this.field282 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field282.add(new class14(var1, var5, var3));
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "32768"
   )
   public void method76(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field282, var1);
      } else {
         Collections.sort(this.field282, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2005171971"
   )
   static int method77() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "-1305790593"
   )
   public static void method78(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class156.field2256, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.putByte(3);
         var3.putByte(var1 != null?1:0);
         var3.putCESU8(var0.getPath());
         if(var1 != null) {
            var3.putCESU8("");
         }

         var2.write(var3.payload, 0, var3.offset);
         var2.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "385586467"
   )
   public static final void method79() {
      while(true) {
         class9 var0 = (class9)class7.field231.method3571();
         if(var0 == null) {
            return;
         }

         var0.vmethod47();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILcj;ZB)I",
      garbageValue = "26"
   )
   static int method75(int var0, Script var1, boolean var2) {
      Widget var3 = class84.method1670(class84.intStack[--class84.intStackSize]);
      if(var0 == 2600) {
         class84.intStack[++class84.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class84.intStack[++class84.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class84.intStack[++class84.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class84.intStack[++class84.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class84.intStack[++class84.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 2606) {
         class84.intStack[++class84.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class84.intStack[++class84.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class84.intStack[++class84.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class84.intStack[++class84.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class84.intStack[++class84.intStackSize - 1] = var3.field2681;
         return 1;
      } else if(var0 == 2611) {
         class84.intStack[++class84.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class84.intStack[++class84.intStackSize - 1] = var3.field2675;
         return 1;
      } else if(var0 == 2613) {
         class84.intStack[++class84.intStackSize - 1] = var3.field2679.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }
}
