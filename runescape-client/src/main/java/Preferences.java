import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 756850881
   )
   static int field1315;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = 1073393479
   )
   static int field1322;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1102060453
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("n")
   String field1319;
   @ObfuscatedName("a")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("q")
   boolean field1320;
   @ObfuscatedName("b")
   @Export("preferences")
   LinkedHashMap preferences;
   @ObfuscatedName("r")
   @Export("muted")
   boolean muted;

   static {
      field1315 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.field1319 = null;
      this.field1320 = false;
      this.preferences = new LinkedHashMap();
      this.method1589(true);
   }

   @ObfuscatedSignature(
      signature = "(Lfp;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.field1319 = null;
      this.field1320 = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1315) {
            if(var1.readUnsignedByte() == 1) {
               this.hideRoofs = true;
            }

            if(var2 > 1) {
               this.muted = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.screenType = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }

            if(var2 > 4) {
               this.field1319 = var1.getNullString();
            }

            if(var2 > 5) {
               this.field1320 = var1.method3253();
            }
         } else {
            this.method1589(true);
         }
      } else {
         this.method1589(true);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1315308903"
   )
   void method1589(boolean var1) {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lfp;",
      garbageValue = "-1538306676"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1315);
      var1.putByte(this.hideRoofs?1:0);
      var1.putByte(this.muted?1:0);
      var1.putByte(this.screenType);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      var1.putString(this.field1319 != null?this.field1319:"");
      var1.method3358(this.field1320);
      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1056208202"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class230.method4119(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lii;Lii;Ljava/lang/String;Ljava/lang/String;I)Ljm;",
      garbageValue = "1083959460"
   )
   public static Font method1596(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.getFile(var2);
      int var5 = var0.getChild(var4, var3);
      return PlayerComposition.method4019(var0, var1, var4, var5);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "549079393"
   )
   static final boolean method1599(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }
}
