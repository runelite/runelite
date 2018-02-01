import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("BoundingBox3DDrawMode")
public class BoundingBox3DDrawMode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   @Export("ON_MOUSEOVER")
   public static final BoundingBox3DDrawMode ON_MOUSEOVER;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   @Export("ALWAYS")
   public static final BoundingBox3DDrawMode ALWAYS;
   @ObfuscatedName("a")
   @Export("highMemory")
   protected static boolean highMemory;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1534439537
   )
   static int field253;

   static {
      ON_MOUSEOVER = new BoundingBox3DDrawMode();
      ALWAYS = new BoundingBox3DDrawMode();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1796841660"
   )
   static void method71(Component var0) {
      var0.addMouseListener(MouseInput.mouse);
      var0.addMouseMotionListener(MouseInput.mouse);
      var0.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "-102"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1496556447"
   )
   static void method72(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }

   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      signature = "(Lho;B)Lho;",
      garbageValue = "34"
   )
   static Widget method73(Widget var0) {
      int var2 = class60.getWidgetConfig(var0);
      int var1 = var2 >> 17 & 7;
      int var3 = var1;
      if(var1 == 0) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = class35.getWidget(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }
}
